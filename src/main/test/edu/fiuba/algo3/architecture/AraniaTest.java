package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;
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
    public void Test2AranialRecibirDanioSeDestruye() {
        Arania arania = new Arania();
        Jugador jugador = new Jugador(10, 100, "Juli");
        Energia danio = new Energia(2);
        arania.recibirDanio(danio, jugador);
        assertTrue(arania.estaMuerto());
    }

    @Test
    public void Test03AraniaDaCreditosCorrectos() {
        Arania arania = new Arania();
        Jugador jugador = new Jugador(10,10,"juli2");

        arania.setRecompensa(new RecompensaSimple());
        arania.recibirDanio(new Energia(2), jugador);
        assertTrue(new Creditos(11).equals(jugador.getCreditos()));

    }

    @Test
    public void Test04AraniaAtacaCorrectamente(){
        Arania arania = new Arania();
        Jugador jugador = new Jugador(10,10,"juli3");
        arania.atacar(jugador);
        assertTrue((new Energia(8)).equals(jugador.getVida()));
    }

}


