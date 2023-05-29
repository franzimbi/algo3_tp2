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
        Coordenadas coordenadas = new Coordenadas(1, 1);
        Tierra tierra = new Tierra(coordenadas);
        Rocoso rocoso = new Rocoso(coordenadas);
        Camino camino = new Camino(coordenadas);

        assertFalse(rocoso.ubicar(defensa));
        assertFalse(camino.ubicar(defensa));
        assertTrue(tierra.ubicar(defensa));

    }

    //TODO: test05 sin terminar, esta complejo
    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        Jugador jugador = new Jugador(20, 100);

        Defensa defensa = Defensa.construirDefensa("torre blanca", jugador);
        Coordenadas coordt = new Coordenadas(6, 7);
        Tierra tierra = new Tierra(coordt);
        tierra.ubicar(defensa);

        Enemigo enemigoHormiga1 = new Hormiga();
        Coordenadas coordc1 = new Coordenadas(8, 9);
        Camino camino1 = new Camino(coordc1);
        camino1.ubicar(enemigoHormiga1);

        assertFalse(defensa.atacar(jugador));

        Enemigo enemigoHormiga2 = new Hormiga();
        Coordenadas coordc2 = new Coordenadas(7, 9);
        Camino camino2 = new Camino(coordc2);
        camino2.ubicar(enemigoHormiga2);

        assertTrue(defensa.atacar(jugador));

        tierra.ubicar(defensa);
        Mapa.getInstancia().reiniciar();
    }

    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Jugador jugador = new Jugador(20, 100);

        Enemigo arania = new Arania();

        arania.recibirDanio(1, jugador);
        assertEquals(1, arania.Vida());
    }

    //TODO: test07 sin terminar
    /*@Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelautorizada(){
    }*/

    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(10, 100);
        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1, jugador);
        assertEquals(101, jugador.obtenerCreditos());

        Hormiga[] hormigas = new Hormiga[9];

        for (int i = 0; i < hormigas.length; i++) {
            hormigas[i] = new Hormiga();
            hormigas[i].recibirDanio(1, jugador);
        }

        assertEquals(110, jugador.obtenerCreditos());
        Hormiga.reiniciar();
    }


}


