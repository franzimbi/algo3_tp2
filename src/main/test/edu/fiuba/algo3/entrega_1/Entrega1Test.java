package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20, 100);

        assertEquals(jugador.obtenerVida(), 20);

        assertEquals(jugador.obtenerCreditos(), 100);
    }

    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        Jugador jugador = new Jugador(20, 100);
        Defensa defensa = Defensa.construirDefensa("torre blanca", jugador);

        assertFalse(defensa.estaOperativa());

        defensa.construir();

        assertTrue(defensa.estaOperativa());
    }

    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = new Jugador(20, 40);

        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada", jugador));

        Defensa defensa = Defensa.construirDefensa("torre plateada", jugador);

        assertThrows(CreditosInsuficientesError.class, () -> Defensa.construirDefensa("torre plateada", jugador));
    }

    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Jugador jugador = new Jugador(20, 100);

        Defensa defensa = Defensa.construirDefensa("torre blanca", jugador);

        Tierra tierra = new Tierra();
        Rocoso rocoso = new Rocoso();
        Pasarela pasarela = new Pasarela();

        assertFalse(rocoso.ubicar(defensa));
        assertFalse(pasarela.ubicar(defensa));
        assertTrue(tierra.ubicar(defensa));

    }
}
