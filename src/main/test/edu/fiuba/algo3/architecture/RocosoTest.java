package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RocosoTest {
    @Test
    public void Test01EnRocosoNoEsPosibleConstruirDefensas() {
        Defensa torreBlanca = Defensa.construirDefensa("torre blanca");
        Defensa torrePlateada = Defensa.construirDefensa("torre plateada");
        Coordenadas coordenadas = new Coordenadas(1, 1);
        Rocoso rocoso = new Rocoso(coordenadas);

        assertFalse(rocoso.ubicar(torreBlanca));
        assertFalse(rocoso.ubicar(torrePlateada));
    }

    @Test
    public void Test03EnRocosoNoEsPosibleUbicarEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();
        Coordenadas coordenadas = new Coordenadas(1, 1);
        Rocoso rocoso = new Rocoso(coordenadas);

        assertFalse(rocoso.ubicar(hormiga));
        assertFalse(rocoso.ubicar(arania));
    }
}
