package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminoTest {

    @Test
    public void Test01CaminoNoPuedeUbicarDefensa() {
        Jugador jugador = Jugador.getInstancia();
        Defensa defensa = Defensa.construirDefensa("torre blanca");
        Coordenadas coordenadas = new Coordenadas(1, 2);
        Camino camino = new Camino(coordenadas);

        assertFalse(camino.ubicar(defensa));

        Jugador.reiniciar();
    }

    @Test
    void Test02CaminoPuedeUbicarEnemigo() {
        Enemigo hormiga = new Hormiga();
        Coordenadas coordenadas = new Coordenadas(1, 2);
        Camino camino = new Camino(coordenadas);

        assertTrue(camino.ubicar(hormiga));
        Mapa.getInstancia().reiniciar();
    }
}
