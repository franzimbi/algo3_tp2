package edu.fiuba.algo3.unitTest.jugadorTest.juegoTest;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.junit.jupiter.api.Test;

public class JuegoTest {

    @Test
    public void Test01JuegoInicialSinMovimientosNoEstaGanado() {
        LectorJSON lector = new LectorJSON();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, lector, mapa, turnos);

        juego.juegoEmpezar();
        assert !juego.gano();
    }

    @Test
    public void Test02JuegoInicialSinMovimientosNoEstaPerdido() {
        LectorJSON lector = new LectorJSON();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, lector, mapa, turnos);

        juego.juegoEmpezar();
        assert !juego.perdio();
    }

    @Test
    public void Test02SimularYVerificarPartidaPerdida() {
        LectorJSON lector = new LectorJSON();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, lector, mapa, turnos);

        juego.juegoEmpezar();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(1, 0));
        juego.pasarTurno();
        juego.agregarDefensa(new TorreBlanca(), new Coordenadas(2, 2));
        assert !juego.perdio();
        juego.pasarTurno();
        assert !juego.perdio();
        juego.pasarTurno();
        assert juego.perdio();
    }

    @Test
    public void Test03SimularYVerificarPartidaGanada() {
        LectorJSON lector = new LectorJSON();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(200, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, lector, mapa, turnos);

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
}
