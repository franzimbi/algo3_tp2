package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = Jugador.getInstancia();

        assertEquals(jugador.getVida(), 20);

        assertEquals(jugador.getCreditos(), 100);
    }

    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        Jugador jugador = Jugador.getInstancia();
        Defensa defensa = Defensa.construirDefensa("torre blanca");

        assertFalse(defensa.estaOperativa());

        defensa.construir();

        assertTrue(defensa.estaOperativa());
    }

    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = Jugador.getInstancia();
        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada"));
        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada"));
        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada"));
        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada"));
        assertDoesNotThrow(() -> Defensa.construirDefensa("torre plateada"));


        assertThrows(CreditosInsuficientesError.class, () -> Defensa.construirDefensa("torre plateada"));

        Jugador.reiniciar();
    }

    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Jugador jugador = Jugador.getInstancia();

        Defensa defensa = Defensa.construirDefensa("torre blanca");
        Coordenadas coordenadas = new Coordenadas(1, 1);
        Tierra tierra = new Tierra(coordenadas);
        Rocoso rocoso = new Rocoso(coordenadas);
        Camino camino = new Camino(coordenadas);

        assertFalse(rocoso.ubicar(defensa));
        assertFalse(camino.ubicar(defensa));
        assertTrue(tierra.ubicar(defensa));

        Jugador.reiniciar();

    }

    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        Jugador jugador = Jugador.getInstancia();

        Defensa defensa = Defensa.construirDefensa("torre blanca");
        Coordenadas coordt = new Coordenadas(6, 7);
        Tierra tierra = new Tierra(coordt);
        tierra.ubicar(defensa);

        Enemigo enemigoHormiga1 = new Hormiga();
        Coordenadas coordc1 = new Coordenadas(8, 9);
        Camino camino1 = new Camino(coordc1);
        camino1.ubicar(enemigoHormiga1);

        assertFalse(defensa.atacar());

        Enemigo enemigoHormiga2 = new Hormiga();
        Coordenadas coordc2 = new Coordenadas(7, 9);
        Camino camino2 = new Camino(coordc2);
        camino2.ubicar(enemigoHormiga2);

        assertTrue(defensa.atacar());

        tierra.ubicar(defensa);
        Mapa.getInstancia().reiniciar();

        Jugador.reiniciar();
    }

    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Jugador jugador = Jugador.getInstancia();

        Enemigo arania = new Arania();

        arania.recibirDanio(1);
        assertEquals(1, arania.Vida());

        Jugador.reiniciar();
    }

    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada() {
        Enemigo hormiga = new Hormiga();

        Coordenadas coord1 = new Coordenadas(0, 0);
        Camino camino = new Camino(coord1);

        Coordenadas coord2 = new Coordenadas(1, 0);
        Rocoso rocoso = new Rocoso(coord2);

        Coordenadas coord3 = new Coordenadas(2, 0);
        Tierra tierra = new Tierra(coord3);

        assertFalse(rocoso.ubicar(hormiga));
        assertFalse(tierra.ubicar(hormiga));
        assertTrue(camino.ubicar(hormiga));
    }

    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = Jugador.getInstancia();
        Enemigo hormiga = new Hormiga();
        hormiga.recibirDanio(1);
        assertEquals(101, jugador.getCreditos());

        Hormiga[] hormigas = new Hormiga[10];

        for (int i = 0; i < hormigas.length; i++) {
            hormigas[i] = new Hormiga();
            hormigas[i].recibirDanio(1);
        }

        assertEquals(112, jugador.getCreditos());
        Hormiga.reiniciar();

        Jugador.reiniciar();
    }

    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Enemigo hormiga = new Hormiga();

        Coordenadas coord1 = new Coordenadas(0, 0);
        Camino camino1 = new Camino(coord1);

        Coordenadas coordSig = new Coordenadas(1, 0);
        Camino caminoSig = new Camino(coordSig);

        camino1.ubicar(hormiga);
        camino1.setSiguiente(caminoSig);

        Mapa mapa = Mapa.getInstancia();

        mapa.moverEnemigos();

        assertSame(caminoSig, hormiga.getCamino());
        assertNotSame(camino1, hormiga.getCamino());

        mapa.reiniciar();
    }

    @Test
    public void Test10ElJugadorGanaEliminandoTodosLosEnemigos() {
        Jugador jugador = Jugador.getInstancia();
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        hormiga.recibirDanio(1);
        arania.recibirDanio(2);

        Mapa mapa = Mapa.getInstancia();

        assertTrue(mapa.gano());
        Hormiga.reiniciar();

        Jugador.reiniciar();
    }

    @Test
    public void Test11ElJugadorGanaEliminandoTodosLosEnemigosAunqueAlgunosLleguenALaMeta() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Coordenadas coordenadas1 = new Coordenadas(0, 0);
        Camino camino1 = new Camino(coordenadas1);

        Coordenadas coordenadas2 = new Coordenadas(1, 0);
        Camino camino2 = new Meta(coordenadas2);

        camino1.setSiguiente(camino2);

        camino1.ubicar(hormiga);
        camino1.ubicar(arania);

        Mapa mapa = Mapa.getInstancia();

        mapa.moverEnemigos();

        assertTrue(mapa.gano());
        Jugador.reiniciar();
    }


    @Test
    public void Test12ElJugadorPierdeSiLosEnemigosQueLlegaronALaMetaYLoMatan() {

        Coordenadas coordenadas1 = new Coordenadas(0, 0);
        Camino camino1 = new Camino(coordenadas1);

        Coordenadas coordenadas2 = new Coordenadas(1, 0);
        Camino camino2 = new Camino(coordenadas2);

        Coordenadas coordenadas3 = new Coordenadas(2, 0);
        Camino camino3 = new Meta(coordenadas3);
        camino1.setSiguiente(camino2);
        camino2.setSiguiente(camino3);

        Enemigo[] enemigos = new Arania[10];
        for (int i = 0; i < enemigos.length; i++) {
            enemigos[i] = new Arania();
            camino1.ubicar(enemigos[i]);
        }

        Mapa mapa = Mapa.getInstancia();

        mapa.moverEnemigos();

        assertTrue(mapa.perdio());
        Jugador.reiniciar();
    }

}




