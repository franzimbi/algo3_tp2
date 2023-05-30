package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = Jugador.getInstancia();

        assertEquals(20, jugador.getVida());

        assertEquals(100, jugador.getCreditos());
        Jugador.reiniciar();
    }

    @Test
    public void Test02UnJugadorRecibeUnCreditoAlMatarUnaHormiga() {
        Jugador jugador = Jugador.getInstancia();
        Enemigo hormiga = new Hormiga();

        assertEquals(100, jugador.getCreditos());

        hormiga.recibirDanio(1);
        assertEquals(101, jugador.getCreditos());
        Hormiga.reiniciar();
        Jugador.reiniciar();
    }

    @Test
    public void Test03UnJugadorRecibeElDobleDeCreditosAlMatarMasDe10Hormigas() {
        Jugador jugador = Jugador.getInstancia();
        for (int i = 0; i < 10; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(1);
        }

        assertEquals(110, jugador.getCreditos());

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1);

        assertEquals(112, jugador.getCreditos());
        Hormiga.reiniciar();
        Jugador.reiniciar();
    }

    @Test
    public void Test04UnJugadorPierdeVidaAlRecibirDaño() {
        Jugador jugador = Jugador.getInstancia();
        Enemigo hormiga = new Hormiga();
        Camino camino = new Camino(new Coordenadas(2, 2));
        camino.ubicar(hormiga);
        hormiga.atacar();
        hormiga.atacar();

        assertEquals(18, jugador.getVida());

    }
}
