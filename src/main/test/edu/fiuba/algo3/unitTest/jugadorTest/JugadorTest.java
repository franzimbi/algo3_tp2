package edu.fiuba.algo3.unitTest.jugadorTest;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");

        assertEquals(20, jugador.getVida());
        assertEquals(100, jugador.getCreditos());
    }


    @Test
    public void Test02UnJugadorRecibeUnCreditoAlMatarUnaHormiga() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Enemigo hormiga = new Hormiga();

        hormiga.recibirDanio(1);
        jugador.recibirMuerto(hormiga);

        assertEquals(101, jugador.getCreditos());
    }

    @Test
    public void Test03UnJugadorRecibeElDobleDeCreditosAlMatarMasDe10Hormigas() {
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
    public void Test04UnJugadorPierdeVidaAlRecibirDanio() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");

        jugador.recibirAtaque(1);

        assertEquals(19, jugador.getVida());
    }

    @Test
    public void Test05UnJugadorPuedeMorir() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");

        jugador.recibirAtaque(20);

        assert jugador.estaMuerto();
    }
}
