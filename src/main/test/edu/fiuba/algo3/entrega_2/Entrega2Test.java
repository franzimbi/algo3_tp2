package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
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
        Lector lector = new Lector();
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.txt"));
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.json"));
        assertDoesNotThrow(() -> lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json"));
    }

    @Test
    public void Test14LecturaDelMapaLanzaExcepcionSiElArchivoEsInvalido() {
        Lector lector = new Lector();
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.txt"));
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.json"));
        assertDoesNotThrow(() -> lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json"));
    }

    @Test
    public void Test15VerificarConversionDelJSONDeEnemigos() {
        Lector lector = new Lector();
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
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Defensa t1 = new TorreBlanca();
        Jugador jugador = new Jugador(1, 100, "Mbappe");

        assertTrue(mapa.agregarDefensa(t1, new Coordenadas(0, 2), jugador)); // mapa me deja agregar la torre en una tierra
        assertFalse(mapa.agregarDefensa(t1, new Coordenadas(0, 1), jugador));// no me deja agregarla en pasarela
        assertFalse(mapa.agregarDefensa(t1, new Coordenadas(0, 0), jugador));// no me deja agregarla en rocoso
    }

    @Test
    public void Test17SimularYVerificarQueElJuegoSeCreeCorrectamenteAcordeAlJSON() {
        //TODO: test17 sin terminar
        //por este test hay que agregar los getters
    }

    @Test
    public void Test18SimularYVerificarPartidaGanada() {
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Turnos turnos = lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json");
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, mapa, turnos);

        juego.juegoEmpezar();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.pasarTurno();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        assert !juego.gano();
        juego.pasarTurno();
        assert juego.gano();
    }

    @Test
    public void Test19SimularYVerificarPartidaPerdida() {
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Turnos turnos = lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json");
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, mapa, turnos);

        juego.juegoEmpezar();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.pasarTurno();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        assert !juego.perdio();
        juego.pasarTurno();
        assert juego.perdio();
    }

    // Verificar el sistema de log a utilizar necesario para la entrega 3. El log puede ser
    // una implementación propia, casera y simple del grupo o utilizar alguna librería.
    @Test
    public void Test20() {
        //TODO: test20 sin terminar
    }


}
