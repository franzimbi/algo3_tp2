package edu.fiuba.algo3.unitTest.mapaTest;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapaTest {
    @Test
    public void Test01MapaSeCreaConTamanioCorrecto() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/testResources/mapaValido.json");
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertDoesNotThrow(() -> mapa.agregarParcela(tierra));
    }

    /*
    @Test
    public void Test02MapaDejaAgregarParcelaEnCoordenadasValidas() {
        Lector lector = new Lector();
        Mapa mapa = lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json");
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertDoesNotThrow(() -> mapa.agregarParcela(tierra));
        Tierra tierra2 = new Tierra(new Coordenadas(4, 4));
        assertThrows(RangoInvalidoMapeadoError.class, () -> mapa.agregarParcela(tierra2));
    }
     */

    @Test
    public void Test03MapaDejaAgregarDefensaEnCoordenadasValidas() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/testResources/mapaValido.json");
        Jugador jugador = new Jugador(1, 100, "Jugador");
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
//        Defensa defensa = new TorrePlateada();
//        assertDoesNotThrow(() -> mapa.agregarParcela(tierra));
//        assertDoesNotThrow(() -> mapa.agregarDefensa(defensa, new Coordenadas(2, 2), jugador));
//        assert !mapa.agregarDefensa(defensa, new Coordenadas(4, 4), jugador);
    }
}
