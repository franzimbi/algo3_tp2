package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
import edu.fiuba.algo3.modelo.enemigos.Topo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasarelaTest {
    @Test
    public void Test01PasarelaPuedeUbicarEnemigos() {
        Pasarela pasarela = new Pasarela(new Coordenadas(0, 0));

        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Hormiga();
        Enemigo topo = new Topo();
        Enemigo lechuza = new Lechuza();

        assertDoesNotThrow(() -> pasarela.ubicar(hormiga));
        assertDoesNotThrow(() -> pasarela.ubicar(arania));
        assertDoesNotThrow(() -> pasarela.ubicar(topo));
        assertDoesNotThrow(() -> pasarela.ubicar(lechuza));
    }

    @Test
    public void Test02PasarelaNoDejaUbicarTorres() {
        Pasarela pasarela = new Pasarela(new Coordenadas(0, 0));

        Defensa torreBlanca = new TorreBlanca();
        Defensa torrePlateada = new TorrePlateada();

        assertThrows(ParcelaNoPuedeUbicarError.class, () -> pasarela.ubicar(torreBlanca));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> pasarela.ubicar(torrePlateada));
    }

    @Test
    public void Test03PasarelaSoloDejaUbicarTrampaDeArena() {
        Pasarela pasarela = new Pasarela(new Coordenadas(0, 0));

        Defensa trampaArenosa = new TrampaArenosa();

        assertDoesNotThrow(() -> pasarela.ubicar(trampaArenosa));
    }

}
