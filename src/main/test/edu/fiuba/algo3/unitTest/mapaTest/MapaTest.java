package edu.fiuba.algo3.unitTest.mapaTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MapaTest {
    @Test
    public void Test01MapaSeCreaConTamanioCorrecto() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/testResources/mapaValido.json");
        Tierra tierra = new Tierra(new Coordenadas(0, 0));
        assertDoesNotThrow(() -> mapa.agregarParcela(tierra));
    }


    @Test
    public void Test03MapaDejaAgregarDefensaEnCoordenadasValidas() {
        LectorJSON lector = new LectorJSON();
        Mapa mapa = lector.leerMapa("src/main/test/testResources/mapaValido.json");
        Jugador jugador = new Jugador(1, 100, "Jugador");
        Defensa defensa = new TorrePlateada();
        assertDoesNotThrow(() -> mapa.ubicar(defensa, new Coordenadas(2, 2), jugador));
    }
    @Test
    public void Test04GetParcelaTieneLasParcelas() {
        Mapa map = new Mapa();
        map.agregarParcela(new Tierra(new Coordenadas(1,1)));
        assert map.getParcelas().size() == 1;
        assert map.encontrarParcela(new Coordenadas(0,0)) == null;

    }
    @Test
    public void Test05GetEnemigosTieneLosEnemigos() {
        Mapa map = new Mapa();
        assert map.getEnemigos().size() == 0;
        assert map.cantidadEnemigos() == 0;
    }
}
