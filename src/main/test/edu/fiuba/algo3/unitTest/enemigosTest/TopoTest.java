package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.modelo.enemigos.Topo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Abajo;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TopoTest {
    @Test
    public void Test01TopoSeIniciaEnUnEstadoValido() {
        Topo topo = new Topo();

        assertFalse(topo.estaMuerto());
        assertEquals(1, topo.getVelocidad());
    }

    @Test
    public void Test02TopoAtacaCorrectamenteEnUnTurnoPar() {
        Topo topo = new Topo();
        Jugador jugador = new Jugador(10, 10, "juli3");
        topo.atacar(jugador, 2);

        assertEquals(8, jugador.getVida());
    }

    @Test
    public void Test03TopoAtacaCorrectamenteEnUnTurnoImpar() {
        Topo topo = new Topo();
        Jugador jugador = new Jugador(10, 10, "juli3");
        topo.atacar(jugador, 1);

        assertEquals(5, jugador.getVida());
    }

    @Test
    public void Test04TopoPasado5TurnosActualizaSuVelocidadCorrectamente() {
        Jugador jugador = new Jugador(10, 10, "juli3");
        Mapa mapa = new Mapa();

        for (int i = 0; i < 11; i++) {
            Pasarela p = new Pasarela(new Coordenadas(0, i));
            mapa.agregarParcela(p);
            p.setSiguiente(new Abajo());
        }

        Topo topo = new Topo();
        mapa.spawnear(topo);

        assert topo.getVelocidad() == 1;

        for (int i = 0; i < 5; i++) {
            mapa.mover(jugador);
        }

        assert topo.getVelocidad() == 2;

        for (int i = 0; i <= 5; i++) {
            mapa.mover(jugador);
        }

        assert topo.getVelocidad() == 3;

    }

}
