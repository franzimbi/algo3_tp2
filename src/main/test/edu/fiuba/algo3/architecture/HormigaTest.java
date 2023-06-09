package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Jugador jugador = new Jugador(10, 100, "Juli");
        Energia danio = new Energia(1);
        hormiga.recibirDanio(danio, jugador);

        assertTrue(hormiga.estaMuerto());
    }

    @Test
    public void Test03HormigaDaCreditosCorrectos() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10, 10, "juli2");
        Energia danio = new Energia(1);
        hormiga.recibirDanio(danio, jugador);
        Creditos creditos = new Creditos(11);

        assertTrue(creditos.equals(jugador.getCreditos()));

    }

    @Test
    public void Test04HormigaAtacaCorrectamente() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10, 10, "juli3");
        hormiga.atacar(jugador);

        assertTrue((new Energia(9)).equals(jugador.getVida()));
    }

    @Test
    public void Test05HormigaPuedeDarElDobleDeCreditosPasado10Muertes() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Energia danio = new Energia(1);

        for (int i = 0; i < 10; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(danio, jugador);
        }

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(danio, jugador);

        Creditos creditos = new Creditos(112);
        Assertions.assertTrue(creditos.equals(jugador.getCreditos()));
    }

    @Test
    public void Test05HormigaSigueDando1CreditoAntesDeSuperarLas10Muertes() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Energia danio = new Energia(1);

        for (int i = 0; i < 9; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(danio, jugador);
        }

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(danio, jugador);

        Creditos creditos = new Creditos(110);
        Assertions.assertTrue(creditos.equals(jugador.getCreditos()));
    }
}


