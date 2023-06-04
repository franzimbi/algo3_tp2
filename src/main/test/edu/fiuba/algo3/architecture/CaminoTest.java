package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Pasarela;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminoTest {

    @Test
    public void Test01CaminoTieneEnemigos() {
        Camino camino = new Camino( new Pasarela(new Coordenadas(0,0)));
        assertFalse(camino.tieneEnemigos());
    }

    @Test
    public void Test02CaminoTieneEnemigos() {
        Jugador jugador = new Jugador(20, 100, "Fran");
        Pasarela pasarela = new Pasarela(new Coordenadas(0,0));
        Enemigo arania = new Arania();
        pasarela.ubicar(arania, jugador);
        Camino camino = new Camino(new Meta(new Coordenadas(0,1)));
        camino.agregarPasarela(pasarela);

        assertTrue(camino.tieneEnemigos());
    }
}
