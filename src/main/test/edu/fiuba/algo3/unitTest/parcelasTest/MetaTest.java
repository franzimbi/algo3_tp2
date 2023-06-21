package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Meta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetaTest {
    @Test
    public void Test01MetaDejaUbicarEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();
        Enemigo topo = new Topo();
        Enemigo lechuza = new Lechuza();

        Meta meta = new Meta(new Coordenadas(1,1));

        assertDoesNotThrow(() -> meta.ubicar(hormiga));
        assertDoesNotThrow(() -> meta.ubicar(arania));
        assertDoesNotThrow(() -> meta.ubicar(topo));
        assertDoesNotThrow(() -> meta.ubicar(lechuza));
    }

    @Test
    public void Test02MetaNoDejaUbicarDefensas() {
        Meta meta = new Meta(new Coordenadas(1,1));

        Defensa torreBlanca = new TorreBlanca();
        Defensa torrePlateada = new TorrePlateada();
        Defensa trampaArenosa = new TrampaArenosa();

        assertThrows(ParcelaNoPuedeUbicarError.class, () -> meta.ubicar(trampaArenosa));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> meta.ubicar(torreBlanca));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> meta.ubicar(torrePlateada));
    }
}
