package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.defensa.*;
import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminoTest {

  @Test
    public void Test01CaminoNoPuedeUbicarDefensa() {
        Jugador jugador = new Jugador(10, 100, "Nico cafe");
        Defensa defensa = new TorreBlanca();

        Camino camino = new Camino(new Meta(new Coordenadas(0,0)));

    }

    @Test
    public void Test02CaminoPuedeUbicarEnemigo() {
        Enemigo hormiga = new Hormiga();

        Camino camino = new Camino(new Meta(new Coordenadas(0,0)));
    }
}
