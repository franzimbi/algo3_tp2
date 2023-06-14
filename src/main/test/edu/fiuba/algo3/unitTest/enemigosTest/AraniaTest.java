package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.unitTest.Mocks.RecompensaRandomMock;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.energia.Energia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AraniaTest {
    @Test
    public void Test01AraniaSeIniciaEnUnEstadoValido() {
        Arania arania = new Arania(new Coordenadas(0,0));

        assertFalse(arania.estaMuerto());
        assertEquals(2, arania.getVelocidad());
    }

    @Test
    public void Test02AranialRecibirDanioSeDestruye() {
        Arania arania = new Arania(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 100, "Juli");
        Energia danio = new EnergiaRoja(3);
        arania.recibirDanio(danio, jugador);
        assertTrue(arania.estaMuerto());
    }

    @Test
    public void Test03AraniaDaCreditosCorrectos() {
        Arania arania = new Arania(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 10, "juli2");

        arania.setRecompensa(new RecompensaRandomMock());
        arania.recibirDanio(new EnergiaRoja(2), jugador);
        assertTrue(new Creditos(11).equals(jugador.getCreditos()));
    }

    @Test
    public void Test04AraniaAtacaCorrectamente() {
        Arania arania = new Arania(new Coordenadas(0,0));
        Jugador jugador = new Jugador(10, 10, "juli3");
        arania.atacar(jugador, 0);
        assertTrue((new EnergiaRoja(8)).equals(jugador.getVida()));
    }


}


