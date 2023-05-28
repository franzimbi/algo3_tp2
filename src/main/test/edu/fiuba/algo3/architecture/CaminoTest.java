package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminoTest {

    @Test
    public void Test01CaminoNoPuedeUbicarDefensa() {
        Jugador jugador = new Jugador(20, 100);
        Defensa defensa = Defensa.construirDefensa("torre blanca", jugador);
        Camino camino = new Camino();

        assertFalse(camino.ubicar(defensa));
    }

    @Test
    void Test02CaminoPuedeUbicarEnemigo() {
        Enemigo hormiga = new Hormiga();
        Camino camino = new Camino();

        assertTrue(camino.ubicar(hormiga));
    }
}
