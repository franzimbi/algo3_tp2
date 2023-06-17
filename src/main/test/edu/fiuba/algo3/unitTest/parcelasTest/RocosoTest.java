package edu.fiuba.algo3.unitTest.parcelasTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Rocoso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RocosoTest {
    @Test
    public void Test01EnRocosoNoEsPosibleConstruirDefensas() {
        Defensa torreBlanca = new TorreBlanca();
        Defensa torrePlateada = new TorrePlateada();

        Rocoso rocoso = new Rocoso(new Coordenadas(1, 1));
        assertFalse(rocoso.ubicar(torreBlanca));
        assertFalse(rocoso.ubicar(torrePlateada));
    }

    @Test
    public void Test03EnRocosoNoEsPosibleUbicarEnemigos() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Rocoso rocoso = new Rocoso(new Coordenadas(1, 1));

        assertFalse(rocoso.ubicar(hormiga));
        assertFalse(rocoso.ubicar(arania));
    }

}
