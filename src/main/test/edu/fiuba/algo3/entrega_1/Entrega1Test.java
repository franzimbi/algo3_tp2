package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    //Verificar que jugador empieza con la vida y los créditos correspondientes.
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20,100,"mati");

        assertFalse(jugador.estaMuerto());
        assertEquals(jugador.getCreditos(), 100);
    }

    //Verificar que cada defensa tarde en construirse lo que dice que
    // tarda y que recién están “operativas” cuando ya se terminaron de construir.
    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        Jugador jugador = new Jugador(20,100,"mati");
        Defensa torre = new TorreBlanca(jugador);

        assertFalse(torre.estaOperativa());
        torre.atacar();
        assertTrue(torre.estaOperativa());
    }

    //Verificar que se disponga de credito para realizar las construcciones.
    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = new Jugador(20,30,"A");
        //assertDoesNotThrow(TorrePlateada::new);
        assertDoesNotThrow(()->new TorrePlateada(jugador));

        assertThrows(CreditosInsuficientesError.class, ()-> new TorrePlateada(jugador));

    }

    //Verificar solo se pueda construir defensas sobre tierra (y verificar lo contrario)
    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Jugador jugador = new Jugador(20,100,"a");
        Defensa defensa = new TorreBlanca(jugador);

        Parcela tierra = new Tierra();
        Parcela roca = new Rocoso();
        Parcela pasarela = new Pasarela();

        assertTrue(tierra.ubicar(defensa));
        assertFalse(roca.ubicar(defensa));
        assertFalse(pasarela.ubicar(defensa));
    }

    //Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        Jugador jugador = new Jugador(20,100,"a");
        Defensa defensa = new TorreBlanca(jugador);
        Enemigo enemigo1 = new Arania();
        Enemigo enemigo2 = new Arania();

        Parcela lejos = new Pasarela(new Coordenadas(0, 5));
        Parcela cerca = new Pasarela(new Coordenadas(0,3));
        Parcela tierra = new Tierra(new Coordenadas(0,1));

        cerca.ubicar(enemigo1);
        lejos.ubicar(enemigo2);
        tierra.ubicar(defensa);

        assertTrue(tierra.defender(cerca));
        assertFalse(tierra.defender(lejos));

    }

    //Verificar que las unidades enemigas son dañadas acorde al ataque recibido.
    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Jugador jugador = new Jugador(20,100,"a");
        Enemigo enemigo = new Arania();
        Defensa defensa = new TorrePlateada(jugador);

        enemigo.recibirDanio(defensa);
        assertTrue(enemigo.estaMuerto());

    }

    //Verificar que las unidades enemigas solo se muevan por la parcela autorizada.
    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada() {
        Enemigo enemigo = new Arania();

        Parcela tierra = new Tierra();
        Parcela piedra = new Rocoso();
        Parcela pasarela = new Pasarela();

        assertFalse(piedra.ubicar(enemigo));
        assertFalse(tierra.ubicar(enemigo));
        assertTrue(pasarela.ubicar(enemigo));
    }


    //Verificar que al destruir una unidad enemiga, el jugador cobra el crédito que le corresponde.
    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(10, 1, "Julian");
        Enemigo enemigo = new Hormiga();

        jugador.recibirCreditos(enemigo.obtenerCreditos());

        assertEquals(jugador.getCreditos(), 2);
    }

    //Verificar que al pasar un turno las unidades enemigas se hayan movido según sus capacidades.
    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Camino camino = new Camino(new Meta(new Coordenadas(0,4)));
        Pasarela pasarela = new Pasarela(new Coordenadas(0,0));
        Pasarela siguienteHormiga = new Pasarela(new Coordenadas(0,1));
        Pasarela siguienteArania = new Pasarela(new Coordenadas(0,2));

        camino.agregarPasarela(pasarela);
        camino.agregarPasarela(siguienteHormiga);
        camino.agregarPasarela(siguienteArania);

        pasarela.ubicar(hormiga);
        pasarela.ubicar(arania);

        camino.mover();

        assertFalse(pasarela.estaVacia());

        assertTrue(siguienteHormiga.estaVacia());

        assertTrue(siguienteArania.estaVacia());
    }

    //Verificar que al eliminar todas la unidades enemigas el jugador gana el juego
    @Test
    public void Test10ElJugadorGanaEliminandoTodosLosEnemigos() {
        Jugador jugador = new Jugador(20,100,"Julian");
        Camino camino = new Camino(new Meta(new Coordenadas(0,3)));

        Pasarela c1 = new Pasarela(new Coordenadas(0,0));
        Pasarela c2 = new Pasarela(new Coordenadas(0,1));
        Pasarela c3 = new Pasarela(new Coordenadas(0,2));




    }


    //Verificar que sin eliminar todas la unidades enemigas, pero las pocas que
    // llegaron a la meta no alcanzan para matar al jugador, este también gana el juego.
//    @Test
//    public void Test11ElJugadorGanaEliminandoTodosLosEnemigosAunqueAlgunosLleguenALaMeta() {
//        Enemigo hormiga = new Hormiga();
//        Enemigo arania = new Arania();
//
//        Camino camino1 = new Camino(new Coordenadas(0, 0));
//        Camino camino2 = new Meta(new Coordenadas(1, 0));
//        camino1.setSiguiente(camino2);
//
//        camino1.ubicar(hormiga);
//        camino1.ubicar(arania);
//
//        Camino mapa = Camino.getInstancia();
//        mapa.moverEnemigos();
//
//        assertTrue(mapa.gano());
//        Jugador.reiniciar();
//    }

    //Verificar que si las unidades enemigas llegadas a la meta matan al jugador, este pierde el juego
   /* @Test
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

        Camino mapa = Camino.getInstancia();
        mapa.moverEnemigos();

        assertTrue(mapa.perdio());
        Jugador.reiniciar();
    }*/
}




