package edu.fiuba.algo3.unitTest.mapaTest;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.junit.jupiter.api.Test;

public class CoordenadasTest {

    @Test
    public void Test01CoordenadaSeInicializaCorrectamente() {
        Coordenadas coordenada = new Coordenadas(1, 1);
        assert coordenada.getX() == 1;
        assert coordenada.getY() == 1;
    }

    @Test
    public void Test02CoordenadaDevuelveLaDistanciaCorrecta() {
        Coordenadas coordenada = new Coordenadas(2, 3);
        Coordenadas otraCoordenada = new Coordenadas(5, 1);
        assert coordenada.distancia(otraCoordenada) == 5;
    }
}
