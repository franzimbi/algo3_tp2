package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TierraTest {
    @Test
    public void Test01TierraUbicarDefensasCorrectamente() {
        Tierra tierra = new Tierra(new Coordenadas(1, 1));
        Tierra tierra1 = new Tierra(new Coordenadas(1, 2));
        assertTrue(tierra.ubicar(new TorreBlanca()));
        assertTrue(tierra1.ubicar(new TorrePlateada()));
    }

    @Test
    public void Test02NoSePuedeUbicarEnemigosEnTierra() {
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertFalse(tierra.ubicar(new Hormiga()));
        assertFalse(tierra.ubicar(new Arania()));
    }
}
