package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {
    @Test
    public void Test13LecturaDeEnemigosLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.txt"));
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.json"));
        assertDoesNotThrow(() -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json"));
    }

    @Test
    public void Test14LecturaDelMapaLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.txt"));
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.json"));
        assertDoesNotThrow(() -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json"));
    }

    @Test
    public void Test15VerificarConversionDelJSONDeEnemigos() {
        LectorJSON lector = new LectorJSON();
        Turnos turnos = lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json");
        Camino camino = new Camino();
        Jugador jugador = new Jugador(5, 1, "Leo Messi");
        camino.agregarPasarela(new Pasarela(new Coordenadas(0, 0)));
        camino.agregarPasarela(new Pasarela(new Coordenadas(0, 1)));
        camino.agregarPasarela(new Pasarela(new Coordenadas(0, 2)));

        assertFalse(camino.tieneEnemigos()); // no debe tener enemigos en el camino
        turnos.generarEnemigos(camino, jugador); // spawneo en el camino 2 veces
        turnos.generarEnemigos(camino, jugador);
        assertTrue(camino.tieneEnemigos());
    }

    @Test
    public void Test16VerificarConversionDelJSONDeMapa() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Defensa t1 = new TorreBlanca();
        Jugador jugador = new Jugador(1, 100, "Mbappe");

        assertTrue(mapa.agregarDefensa(t1, new Coordenadas(0, 2), jugador)); // mapa me deja agregar la torre en una tierra
        assertFalse(mapa.agregarDefensa(t1, new Coordenadas(0, 1), jugador));// no me deja agregarla en pasarela
        assertFalse(mapa.agregarDefensa(t1, new Coordenadas(0, 0), jugador));// no me deja agregarla en rocoso
        assert (mapa.tamanoMapa() == 3 * 3);
    }

    @Test
    public void Test17SimularYVerificarQueElJuegoSeCreeCorrectamenteAcordeAlJSON() {
        String mapa = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json";
        String turnos = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        assert (juego.tamanoMapa() == 3 * 3);
        assert (juego.cantidadTurnos() == 2);
        assert (juego.cantidadEnemigos(0) == 0);
        assert (juego.cantidadEnemigos(1) == 0);
        assert (juego.cantidadEnemigos(2) == 0);

        juego.juegoEmpezar();
        assert (juego.cantidadEnemigos(0) == 1);
        juego.pasarTurno();
        assert (juego.cantidadEnemigos(0) == 2);
        assert (juego.cantidadEnemigos(1) == 1);
        juego.pasarTurno();
        assert (juego.cantidadEnemigos(0) == 0);
        assert (juego.cantidadEnemigos(1) == 1);
        assert (juego.cantidadEnemigos(2) == 0);
    }

    @Test
    public void Test18SimularYVerificarPartidaGanada() {
        String mapa = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json";
        String turnos = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        juego.juegoEmpezar();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.pasarTurno();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        assert !juego.gano();
        juego.pasarTurno();
        assert !juego.gano();
        juego.pasarTurno();
        assert juego.gano();
    }

    @Test
    public void Test19SimularYVerificarPartidaPerdida() {
        String mapa = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json";
        String turnos = "src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json";
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        juego.juegoEmpezar();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.pasarTurno();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        assert !juego.perdio();
        juego.pasarTurno();
        assert juego.perdio();
    }
}
