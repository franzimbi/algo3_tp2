package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Entrega2Test {
    @Test
    public void Test13LecturaDeEnemigosLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/testResources/enemigosInvalidos.txt"));
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/testResources/enemigosInvalidos.json"));
        assertDoesNotThrow(() -> lector.leerEnemigos("src/main/test/testResources/enemigosValidos.json"));
    }

    @Test
    public void Test14LecturaDelMapaLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/testResources/mapaInvalido.txt"));
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/testResources/mapaInvalido.json"));
        assertDoesNotThrow(() -> lector.leerMapa("src/main/test/testResources/mapaValido.json"));
    }

    @Test
    public void Test15VerificarConversionDelJSONDeEnemigos() {
        LectorJSON lector = new LectorJSON();
        Turnos turnos = lector.leerEnemigos("src/main/test/testResources/enemigosValidos.json");
        //Jugador jugador = new Jugador(5, 1, "Leo Messi");
        Mapa mapa = new Mapa();
        Pasarela ini = new Pasarela(new Coordenadas(0, 0));
        mapa.agregarParcela(ini);
        mapa.agregarParcela(new Pasarela(new Coordenadas(0, 1)));
        mapa.agregarParcela(new Pasarela(new Coordenadas(0, 2)));

        assertEquals(0, mapa.cantidadEnemigos()); // no debe tener enemigos en el camino
        turnos.generarEnemigos(mapa); // spawneo en el camino 2 veces
        assertEquals(1, mapa.cantidadEnemigos());
        turnos.generarEnemigos(mapa);
        assertEquals(3, mapa.cantidadEnemigos());
    }

    @Test
    public void Test16VerificarConversionDelJSONDeMapa() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/testResources/mapaValido.json");
        Defensa t1 = new TorreBlanca();
        Jugador jugador = new Jugador(1, 100, "Mbappe");

        mapa.ubicar(t1, new Coordenadas(0, 2), jugador); // mapa me deja agregar la torre en una tierra
        assert t1.getUbicacion().equals(new Coordenadas(0, 2));
        mapa.ubicar(t1, new Coordenadas(0, 1), jugador);// no me deja agregarla en pasarela
        assert !t1.getUbicacion().equals(new Coordenadas(0, 1));
        assert t1.getUbicacion().equals(new Coordenadas(0, 2));
        mapa.ubicar(t1, new Coordenadas(0, 0), jugador);// no me deja agregarla en rocoso
        assert !t1.getUbicacion().equals(new Coordenadas(0, 0));
        assert t1.getUbicacion().equals(new Coordenadas(0, 2));
    }

    @Test
    public void Test17SimularYVerificarQueElJuegoSeCreeCorrectamenteAcordeAlJSON() {
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        assert (juego.tamanoMapa() == 3 * 3);
        assert (juego.cantidadDeOleadas() == 2);
        assertEquals(0, juego.cantidadEnemigos());
        assertEquals(0, jugador.cantidadDefensas());
        juego.juegoEmpezar();
        assertEquals(1, juego.cantidadEnemigos());
        assertEquals(0, jugador.cantidadDefensas());
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(0, 2));
        assertEquals(1, jugador.cantidadDefensas());
        juego.pasarTurno();
        assertEquals(3, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(0, juego.cantidadEnemigos());
    }

    @Test
    public void Test18SimularYVerificarPartidaGanada() {
        //Logger.getInstancia().activar();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        juego.juegoEmpezar();
        assertEquals(1, juego.cantidadEnemigos());
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        juego.pasarTurno();
        assertEquals(3, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(0, juego.cantidadEnemigos());
        assert juego.gano();
        assertEquals(282, jugador.getCreditos());
        assertEquals(18, jugador.getVida());
        //Logger.getInstancia().desactivar();
    }

    @Test
    public void Test19SimularYVerificarPartidaPerdida() {
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        juego.juegoEmpezar();
        assertEquals(1, juego.cantidadEnemigos());
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        juego.pasarTurno();
        assertEquals(3, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(0, juego.cantidadEnemigos());
        assert juego.perdio();
        assertEquals(282, jugador.getCreditos());
        assertEquals(0, jugador.getVida());
    }
}
