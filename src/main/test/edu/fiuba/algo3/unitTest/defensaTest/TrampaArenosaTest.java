package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrampaArenosaTest {

    @Test
    public void Test02TrampaDeArenaEstaOperativa() {
        TrampaArenosa trampa = new TrampaArenosa();
        assert (trampa.estaOperativa());
    }

    @Test
    public void Test04TrampaDeArenaSacaCreditosCorrector() {
        TrampaArenosa trampa = new TrampaArenosa();
        Jugador jugador = new Jugador(10, 100, "Jugador");
        trampa.asignarAJugador(jugador);
        assertEquals(75, jugador.getCreditos());
    }

    @Test
    public void Test04TrampaDeArenaNoMataAlEnemigo() {
        TrampaArenosa trampa = new TrampaArenosa();
        Hormiga hormiga = new Hormiga();
        trampa.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void Test05TrampaDeArenaReduceLaVelocidad() {
        TrampaArenosa trampa = new TrampaArenosa();
        Hormiga hormiga = new Hormiga();
        trampa.atacarEnemigo(hormiga);
        assert hormiga.getVelocidad() == 0;
    }

    @Test
    public void Test06TrampaDeArenaAtacaCorrectamenteATodosLosEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();
        Enemigo topo = new Topo();
        Enemigo lechuza = new Lechuza();

        TrampaArenosa trampa = new TrampaArenosa();

        trampa.atacarEnemigo(hormiga);
        trampa.atacarEnemigo(arania);
        trampa.atacarEnemigo(topo);
        trampa.atacarEnemigo(lechuza);

        assert hormiga.getVelocidad() == 0;
        assert arania.getVelocidad() == 1;
        assert topo.getVelocidad() == 0;
        assert lechuza.getVelocidad() == 5;

    }

    @Test
    public void Test07TrampaDeArenaDuraSolo3Turnos() {
        LectorJSON lector = new LectorJSON();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(200, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, lector, mapa, turnos);

        Defensa trampa = new TrampaArenosa();
        juego.agregarDefensa(trampa, new Coordenadas(0, 1));

        juego.juegoEmpezar();
        juego.pasarTurno();
        assert trampa.vidaUtil();
        juego.pasarTurno();
        assert trampa.vidaUtil();
        juego.pasarTurno();
        assert trampa.vidaUtil();
        juego.pasarTurno();
        assert !trampa.vidaUtil();
        assert jugador.cantidadDefensas() == 0;


    }

}
