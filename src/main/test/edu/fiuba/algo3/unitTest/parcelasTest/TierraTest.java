package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TierraTest {
    @Test
    public void Test01TierraUbicarDefensasCorrectamente() {
        Tierra tierra = new Tierra(new Coordenadas(1, 1));
        Tierra tierra1 = new Tierra(new Coordenadas(1, 2));
        assertDoesNotThrow(()->tierra.ubicar(new TorreBlanca()));
        assertDoesNotThrow(()->tierra1.ubicar(new TorreBlanca()));
    }

    @Test
    public void Test02NoSePuedeUbicarEnemigosEnTierra() {
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->tierra.ubicar(new Hormiga()));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->tierra.ubicar(new Arania()));
    }

    @Test
    public void Test03TierraNoDejaUbicarTrampaDeArena() {
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->tierra.ubicar(new TrampaArenosa()));
    }
}
