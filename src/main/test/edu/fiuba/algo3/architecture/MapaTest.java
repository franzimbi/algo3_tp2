package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {

    @Test
    public void Test01UnJugadorGanaConUnMapaSinEnemigos() {
        Mapa mapa = Mapa.getInstancia();
        assertTrue(mapa.gano());

        mapa.reiniciar();
        Jugador.reiniciar();

    }

    @Test
    public void Test02UnMapaUbicaUnEnemigoCorrectamente() {
        Enemigo hormiga = new Hormiga();

        Coordenadas coord1 = new Coordenadas(0, 0);
        Camino camino1 = new Camino(coord1);
        camino1.ubicar(hormiga);

        Coordenadas coord2 = new Coordenadas(1, 0);
        Camino camino2 = new Camino(coord2);

        Mapa mapa = Mapa.getInstancia();

        assertSame(hormiga, mapa.getObjetivo(camino2));

        mapa.reiniciar();
        Jugador.reiniciar();
    }

    @Test
    public void Test03UnJugadorMuertoPierde() {
        Jugador jugador = Jugador.getInstancia();

        jugador.rebibirDaño(100);
        assertTrue(jugador.estaMuerto());

        Mapa mapa = Mapa.getInstancia();

        assertTrue(mapa.perdio());

        mapa.reiniciar();
        Jugador.reiniciar();
    }

    @Test
    public void Test04UnEnemigoSeMueveCorrectamente() {
        Enemigo arania = new Arania();

        Camino camino1 = new Camino(new Coordenadas(0, 0));

        Camino caminoSig = new Camino(new Coordenadas(2, 0));

        camino1.ubicar(arania);
        camino1.setSiguiente(caminoSig);

        Mapa mapa = Mapa.getInstancia();

        mapa.moverEnemigos();

        assertSame(caminoSig, arania.getCamino());
        assertNotSame(camino1, arania.getCamino());

        mapa.reiniciar();
        Jugador.reiniciar();
    }

}
