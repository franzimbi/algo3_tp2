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

    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada(){
        Enemigo hormiga = new Hormiga();

        Coordenadas coord1 = new Coordenadas(0,0);
        Camino camino = new Camino(coord1);

        Coordenadas coord2 = new Coordenadas(1,0);
        Rocoso rocoso = new Rocoso(coord2);

        Coordenadas coord3 = new Coordenadas(2,0);
        Tierra tierra = new Tierra(coord3);

        assertFalse(rocoso.ubicar(hormiga));
        assertFalse(tierra.ubicar(hormiga));
        assertTrue(camino.ubicar(hormiga));
    }

    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(10, 100);
        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1, jugador);
        assertEquals(101, jugador.obtenerCreditos());

        Hormiga[] hormigas = new Hormiga[10];

        for (int i = 0; i < hormigas.length; i++) {
            hormigas[i] = new Hormiga();
            hormigas[i].recibirDanio(1, jugador);
        }

        assertEquals(112, jugador.obtenerCreditos());
        Hormiga.reiniciar();
    }

    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Enemigo hormiga = new Hormiga();

        Coordenadas coord1 = new Coordenadas(0,0);
        Camino camino1 = new Camino(coord1);

        Coordenadas coordSig = new Coordenadas(1,0);
        Camino caminoSig = new Camino(coordSig);

        camino1.ubicar(hormiga);
        camino1.setSiguiente(caminoSig);

        hormiga.mover();

        assertSame(caminoSig, hormiga.getCamino());
        assertNotSame(camino1, hormiga.getCamino());

    }

    @Test
    public void Test10ElJugadorGanaEliminandoTodosLosEnemigos() {

    }

}




