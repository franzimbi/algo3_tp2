package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Rocoso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RocosoTest {
    @Test
    public void Test01EnRocosoNoEsPosibleConstruirDefensas() {
        Defensa torreBlanca = new TorreBlanca();
        Defensa torrePlateada = new TorrePlateada();
        Defensa trampaArenosa = new TorrePlateada();

        Rocoso rocoso = new Rocoso(new Coordenadas(1, 1));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->rocoso.ubicar(torreBlanca));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->rocoso.ubicar(torrePlateada));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->rocoso.ubicar(trampaArenosa));
    }

    @Test
    public void Test03EnRocosoNoEsPosibleUbicarEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Rocoso rocoso = new Rocoso(new Coordenadas(1, 1));

        assertThrows(ParcelaNoPuedeUbicarError.class, ()->rocoso.ubicar(hormiga));
        assertThrows(ParcelaNoPuedeUbicarError.class, ()->rocoso.ubicar(arania));
    }

}
