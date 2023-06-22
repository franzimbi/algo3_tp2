package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.unitTest.Mocks.RecompensaRandomMock;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AraniaTest {
    @Test
    public void Test01AraniaSeIniciaEnUnEstadoValido() {
        Arania arania = new Arania();

        assertFalse(arania.estaMuerto());
        assertEquals(2, arania.getVelocidad());
    }

    @Test
    public void Test02AraniAlRecibirDanioSeDestruye() {
        Arania arania = new Arania();
        arania.recibirDanio(3);
        assertTrue(arania.estaMuerto());
    }

    @Test
    public void Test03AraniaDaCreditosCorrectos() {
        Arania arania = new Arania();
        Jugador jugador = new Jugador(10, 10, "juli2");

        arania.setRecompensa(new RecompensaRandomMock());
        arania.recibirDanio(2);
        jugador.recibirMuerto(arania);
        assertEquals(11, jugador.getCreditos());
    }

    @Test
    public void Test04AraniaAtacaCorrectamente() {
        Arania arania = new Arania();
        Jugador jugador = new Jugador(10, 10, "juli3");
        arania.atacar(jugador, 0);
        assertEquals(8, jugador.getVida());
    }

}


