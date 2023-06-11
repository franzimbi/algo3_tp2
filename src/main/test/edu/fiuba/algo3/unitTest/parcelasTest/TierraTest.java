package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TierraTest {
    @Test
    public void Test01TierraUbicarDefensasCorrectamente() {
        Jugador jugador = new Jugador(100,100,"Juli");
        Tierra tierra = new Tierra(new Coordenadas(1,1));
        Tierra tierra1 = new Tierra(new Coordenadas(1,2));
        assertTrue(tierra.ubicar(new TorreBlanca(),jugador));
        assertTrue(tierra1.ubicar(new TorrePlateada(),jugador));
    }

    @Test
    public void Test02NoSePuedeUbicarEnemigosEnTierra() {
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        Jugador jugador = new Jugador(100,100,"Juli");
        assertFalse(tierra.ubicar(new Hormiga(),jugador));
        assertFalse(tierra.ubicar(new Arania(),jugador));
    }

    /*@Test
    public void Test03TierraVaciaNoAtaca(){
        Tierra tierra = new Tierra(new Coordenadas(1,1));
        Jugador jugador = new Jugador(100,100,"Juli");
        Pasarela pasarela = new Pasarela(new Coordenadas(1,2));
        Hormiga hormiga = new Hormiga();
        pasarela.ubicar(hormiga,jugador);
        assertThrows(NoHayDefensaEnTierraError.class, () -> tierra.atacar(pasarela,jugador));

    }*/
}
