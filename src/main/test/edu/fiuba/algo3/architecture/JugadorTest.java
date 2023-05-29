package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = Jugador.getInstancia();

        assertEquals(20,jugador.getVida());

        assertEquals(100,jugador.obtenerCreditos());
        Jugador.reiniciar();
    }

    @Test
    public void Test02UnJugadorRecibeUnCreditoAlMatarUnaHormiga() {
        Jugador jugador = Jugador.getInstancia();
        Enemigo hormiga = new Hormiga();

        assertEquals(100, jugador.obtenerCreditos());

        hormiga.recibirDanio(1);
        assertEquals(101, jugador.obtenerCreditos());
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

        assertEquals(110, jugador.obtenerCreditos());

        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1);

        assertEquals(112, jugador.obtenerCreditos());
        Hormiga.reiniciar();
        Jugador.reiniciar();
    }

    //TODO: implementar logica del usuario recibiendo daño
    /*@Test
    public void Test04UnJugadorPierdeVidaAlRecibirDaño(){}*/
}
