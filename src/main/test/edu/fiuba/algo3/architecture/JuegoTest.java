package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.junit.jupiter.api.Test;

public class JuegoTest {

    @Test
    public void Test01JuegoInicialSinMovimientosNoEstaGanado() {
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Turnos turnos = lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json");
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, mapa, turnos);

        juego.juegoEmpezar();
        assert !juego.gano();
    }

    @Test
    public void Test02JuegoInicialSinMovimientosNoEstaPerdido() {
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Turnos turnos = lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json");
        Jugador jugador = new Jugador(2, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, mapa, turnos);

        juego.juegoEmpezar();
        assert !juego.perdio();
    }

    @Test
    public void Test02SimularYVerificarPartidaPerdida() {
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

    @Test
    public void Test03SimularYVerificarPartidaGanada() {
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
        assert !juego.gano();
        juego.pasarTurno();
        assert juego.gano();
    }
}
