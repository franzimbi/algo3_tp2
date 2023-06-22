package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HormigaTest {

    @Test
    public void Test01HormigaSeIniciaEnUnEstadoValido() {
        Hormiga hormiga = new Hormiga();

        assertFalse(hormiga.estaMuerto());
        assertEquals(1, hormiga.getVelocidad());

    }

    @Test
    public void Test2HormigaAlRecibirDanioSeDestruye() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(1);

        assertTrue(hormiga.estaMuerto());
    }

    @Test
    public void Test03HormigaDaCreditosCorrectos() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10, 10, "juli2");
        hormiga.recibirDanio(1);
        jugador.recibirMuerto(hormiga);

        assertEquals(11, jugador.getCreditos());
    }

    @Test
    public void Test04HormigaAtacaCorrectamente() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10, 10, "juli3");
        hormiga.atacar(jugador, 0);

        assertEquals(9, jugador.getVida());
    }

    @Test
    public void Test05HormigaPuedeDarElDobleDeCreditosPasado10Muertes() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");

        for (int i = 0; i < 10; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(1);
            jugador.recibirMuerto(hormiga);
        }

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1);
        jugador.recibirMuerto(hormiga);

        assertEquals(112, jugador.getCreditos());
    }

    @Test
    public void Test05HormigaSigueDando1CreditoAntesDeSuperarLas10Muertes() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");

        for (int i = 0; i < 9; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(1);
            jugador.recibirMuerto(hormiga);
        }

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1);
        jugador.recibirMuerto(hormiga);

        assertEquals(110, jugador.getCreditos());
    }
}


