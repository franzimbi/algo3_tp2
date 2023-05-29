package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20, 100);

        assertEquals(jugador.obtenerVida(), 20);

        assertEquals(jugador.obtenerCreditos(), 100);
    }

    @Test
    public void Test02UnJugadorRecibeUnCreditoAlMatarUnaHormiga() {
        Jugador jugador = new Jugador(20, 100);
        Enemigo hormiga = new Hormiga();

        assertEquals(100, jugador.obtenerCreditos());

        hormiga.recibirDanio(1, jugador);
        assertEquals(101, jugador.obtenerCreditos());
        Hormiga.reiniciar();
    }

    @Test
    public void Test03UnJugadorRecibeElDobleDeCreditosAlMatarMasDe10Hormigas() {
        Jugador jugador = new Jugador(20, 100);

        for (int i = 0; i < 10; i++) {
            Enemigo hormiga = new Hormiga();
            hormiga.recibirDanio(1, jugador);
        }

        assertEquals(110, jugador.obtenerCreditos());

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1, jugador);

        assertEquals(112, jugador.obtenerCreditos());
        Hormiga.reiniciar();
    }

    //TODO: implementar logica del usuario recibiendo daño
    /*@Test
    public void Test04UnJugadorPierdeVidaAlRecibirDaño(){}*/
}
