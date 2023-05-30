package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    //Verificar que jugador empieza con la vida y los créditos correspondientes.
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = Jugador.getInstancia();

        assertEquals(jugador.getVida(), 20);

        assertEquals(jugador.getCreditos(), 100);
    }

    //Verificar que cada defensa tarde en construirse lo que dice que
    // tarda y que recién están “operativas” cuando ya se terminaron de construir.
    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        Jugador jugador = Jugador.getInstancia();
        Defensa defensa = new TorreBlanca();

        assertFalse(defensa.estaOperativa());

        defensa.construir();

        assertTrue(defensa.estaOperativa());
    }

    //Verificar que se disponga de credito para realizar las construcciones.
    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = Jugador.getInstancia();
        assertDoesNotThrow(TorrePlateada::new);
        assertDoesNotThrow(TorrePlateada::new);
        assertDoesNotThrow(TorrePlateada::new);
        assertDoesNotThrow(TorrePlateada::new);
        assertDoesNotThrow(TorrePlateada::new);

        assertThrows(CreditosInsuficientesError.class, TorrePlateada::new);

        Jugador.reiniciar();
    }

    //Verificar solo se pueda construir defensas sobre tierra (y verificar lo contrario)
    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Jugador jugador = Jugador.getInstancia();
        Defensa defensa = new TorreBlanca();

        Coordenadas coordenadas = new Coordenadas(1, 1);
        Tierra tierra = new Tierra(coordenadas);
        Rocoso rocoso = new Rocoso(coordenadas);
        Camino camino = new Camino(coordenadas);

        assertFalse(rocoso.ubicar(defensa));
        assertFalse(camino.ubicar(defensa));
        assertTrue(tierra.ubicar(defensa));

        Jugador.reiniciar();

    }

    //Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        Jugador jugador = Jugador.getInstancia();


        Defensa defensa = new TorreBlanca();
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

    //Verificar que las unidades enemigas son dañadas acorde al ataque recibido.
    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Jugador jugador = Jugador.getInstancia();

        Enemigo arania = new Arania();

        arania.recibirDanio(1);
        assertEquals(1, arania.Vida());

        Jugador.reiniciar();
    }

    //Verificar que las unidades enemigas solo se muevan por la parcela autorizada.
    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada() {
        Enemigo hormiga = new Hormiga();

        Camino camino = new Camino(new Coordenadas(0, 0));
        Rocoso rocoso = new Rocoso(new Coordenadas(1, 0));
        Tierra tierra = new Tierra(new Coordenadas(2, 0));

        assertFalse(rocoso.ubicar(hormiga));
        assertFalse(tierra.ubicar(hormiga));
        assertTrue(camino.ubicar(hormiga));
    }

    //Verificar que al destruir una unidad enemiga, el jugador cobra el crédito que le corresponde.
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

    //Verificar que al pasar un turno las unidades enemigas se hayan movido según sus capacidades.
    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Enemigo hormiga = new Hormiga();

        Camino camino1 = new Camino(new Coordenadas(0, 0));
        Camino caminoSig = new Camino(new Coordenadas(1, 0));

        camino1.ubicar(hormiga);
        camino1.setSiguiente(caminoSig);

        Mapa mapa = Mapa.getInstancia();
        mapa.moverEnemigos();

        assertSame(caminoSig, hormiga.getCamino());
        assertNotSame(camino1, hormiga.getCamino());

        mapa.reiniciar();
    }

    //Verificar que al eliminar todas la unidades enemigas el jugador gana el juego
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

    //Verificar que sin eliminar todas la unidades enemigas, pero las pocas que
    // llegaron a la meta no alcanzan para matar al jugador, este también gana el juego.
    @Test
    public void Test11ElJugadorGanaEliminandoTodosLosEnemigosAunqueAlgunosLleguenALaMeta() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Camino camino1 = new Camino(new Coordenadas(0, 0));
        Camino camino2 = new Meta(new Coordenadas(1, 0));
        camino1.setSiguiente(camino2);

        camino1.ubicar(hormiga);
        camino1.ubicar(arania);

        Mapa mapa = Mapa.getInstancia();
        mapa.moverEnemigos();

        assertTrue(mapa.gano());
        Jugador.reiniciar();
    }

    //Verificar que si las unidades enemigas llegadas a la meta matan al jugador, este pierde el juego
    @Test
    public void Test12ElJugadorPierdeSiLosEnemigosQueLlegaronALaMetaYLoMatan() {
        Camino camino1 = new Camino(new Coordenadas(0, 0));
        Camino camino2 = new Camino(new Coordenadas(1, 0));
        Camino camino3 = new Meta(new Coordenadas(2, 0));

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




