package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.junit.jupiter.api.Test;


public class TrampaArenosaTest {
    @Test
    public void Test01TrampaDeArenaEstaEnRango() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        assert (trampa.estaEnRango(0));
    }

    @Test
    public void Test02TrampaDeArenaEstaOperativa() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        assert (trampa.estaOperativa());
    }

    @Test
    public void Test03TrampaDeArenaNoEstaEnRango() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        assert (!trampa.estaEnRango(1));
    }

    @Test
    public void Test04TrampaDeArenaSacaCreditosCorrector() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 100, "Jugador");
        trampa.asignarAJugador(jugador);
        Creditos creditos = new Creditos(75);
        assert creditos.equals(jugador.getCreditos());
    }

    @Test
    public void Test04TrampaDeArenaNoMataAlEnemigo() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 100, "Jugador");
        Hormiga hormiga = new Hormiga(new Coordenadas(0,0));
        trampa.atacarEnemigo(hormiga, jugador);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void Test05TrampaDeArenaReduceLaVelocidad() {
        TrampaArenosa trampa = new TrampaArenosa(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 100, "Jugador");
        Hormiga hormiga = new Hormiga(new Coordenadas(0,0));
        trampa.atacarEnemigo(hormiga, jugador);
        assert hormiga.getVelocidad() == 0;
    }
}
