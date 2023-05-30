package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TierraTest {
    @Test
    public void Test02EnTierraEsPosibleconstruirDefensas() {
        Defensa torreBlanca = Defensa.construirDefensa("torre blanca");
        Defensa torrePlateada = Defensa.construirDefensa("torre plateada");
        Rocoso rocoso = new Rocoso(new Coordenadas(0, 0));

        assertFalse(rocoso.ubicar(torreBlanca));
        assertFalse(rocoso.ubicar(torrePlateada));
    }

    @Test
    public void Test03EnNoEsPosibleUbicarEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();
        Tierra tierra = new Tierra(new Coordenadas(0, 0));

        assertFalse(tierra.ubicar(hormiga));
        assertFalse(tierra.ubicar(arania));
    }
}
