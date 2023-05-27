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
        Camino camino = new Camino();

        assertFalse(rocoso.ubicar(defensa));
        assertFalse(camino.ubicar(defensa));
        assertTrue(tierra.ubicar(defensa));

    }

    //TODO: Sin terminar, esta complejo
    /*@Test
    public void Test05LasDefensasAtaquenDentroDelRangoEsperado() {
        Jugador jugador = new Jugador(20, 100);

        Defensa defensa = Defensa.construirDefensa("torre blanca", jugador);
        Enemigo enemigoHormiga = new Hormiga();

        Camino camino = new Camino();
        Tierra tierra = new Tierra();

        camino.ubicar(enemigoHormiga);
        tierra.ubicar(defensa);

    }*/

    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Enemigo arania = new Arania();

        arania.recibirDanio(1);
        assertEquals(arania.Vida(), 1);
    }

    //TODO: Sin terminar
    /*@Test
    public void Test07(){
    }*/

    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos(){
        Jugador jugador = new Jugador(10,100);
        Enemigo hormiga = new Hormiga();

        hormiga.recibirDanio(1);

        assertEquals(jugador.obtenerCreditos(),101);

    }
}


