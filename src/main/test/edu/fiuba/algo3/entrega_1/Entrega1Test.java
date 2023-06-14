package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Rocoso;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    //Verificar que jugador empieza con la vida y los créditos correspondientes.
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20, 100, "mati");

        assertFalse(jugador.estaMuerto());
        assertTrue(jugador.getCreditos().equals(new Creditos(100)));
    }

    //Verificar que cada defensa tarde en construirse lo que dice que
    // tarda y que recién están “operativas” cuando ya se terminaron de construir.
    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        Jugador jugador = new Jugador(20, 100, "mati");
        Enemigo enemigo = new Arania(new Coordenadas(0,0));
        Defensa torre = new TorreBlanca(new Coordenadas(0,1));

        assertFalse(torre.estaOperativa());
        torre.atacarEnemigo(enemigo, jugador);
        assertTrue(torre.estaOperativa());
    }

    //Verificar que se disponga de credito para realizar las construcciones.
    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = new Jugador(20, 2, "A");
        Defensa torre = new TorrePlateada(new Coordenadas(0,0));
        assertThrows(CreditosInsuficientesError.class, () -> torre.asignarAJugador(jugador));
    }

    //Verificar solo se pueda construir defensas sobre tierra (y verificar lo contrario)
    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Jugador jugador = new Jugador(20, 100, "a");
        Defensa defensa = new TorreBlanca(new Coordenadas(0,0));

        Parcela tierra = new Tierra(new Coordenadas(0, 0));
        Parcela roca = new Rocoso(new Coordenadas(1, 1));
        Parcela pasarela = new Pasarela(new Coordenadas(0, 1));

        assertTrue(tierra.ubicar(defensa));
        assertFalse(roca.ubicar(defensa));
        assertFalse(pasarela.ubicar(defensa));
    }

    //Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        Jugador jugador = new Jugador(20, 100, "a");
        Defensa defensa = new TorreBlanca(new Coordenadas(0,0));
        Enemigo enemigo1 = new Hormiga(new Coordenadas(0,3));
        Enemigo enemigo2 = new Hormiga(new Coordenadas(0,5));

        Pasarela lejos = new Pasarela(new Coordenadas(0, 5));
        Pasarela cerca = new Pasarela(new Coordenadas(0, 3));
        Tierra tierra = new Tierra(new Coordenadas(0, 1));

        cerca.ubicar(enemigo1);
        lejos.ubicar(enemigo2);
        tierra.ubicar(defensa);

        defensa.atacarEnemigo(enemigo2, jugador);
        defensa.atacarEnemigo(enemigo1, jugador); //esto pone la torre en operacion
        defensa.atacarEnemigo(enemigo1, jugador);

        assertTrue(enemigo1.estaMuerto());
        assertFalse(enemigo2.estaMuerto());
    }

    //Verificar que las unidades enemigas son dañadas acorde al ataque recibido.
    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        Jugador jugador = new Jugador(20, 100, "a");
        Enemigo enemigo = new Arania(new Coordenadas(0,0));

        Energia energia = new EnergiaRoja(2);

        enemigo.recibirDanio(energia, jugador);
        assertTrue(enemigo.estaMuerto());

    }

    //Verificar que las unidades enemigas solo se muevan por la parcela autorizada.
    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada() {
        Jugador jugador = new Jugador(20, 100, "a");
        Enemigo enemigo = new Arania(new Coordenadas(1,1));

        Parcela tierra = new Tierra(new Coordenadas(0, 0));
        Parcela piedra = new Rocoso(new Coordenadas(1, 0));
        Parcela pasarela = new Pasarela(new Coordenadas(1, 1));

        assertFalse(piedra.ubicar(enemigo));
        assertFalse(tierra.ubicar(enemigo));
        assertTrue(pasarela.ubicar(enemigo));
    }


    //Verificar que al destruir una unidad enemiga, el jugador cobra el crédito que le corresponde.
    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(10, 1, "Julian");
        Enemigo enemigo = new Hormiga(new Coordenadas(0,0));
        Energia energia = new EnergiaRoja(1);

        enemigo.recibirDanio(energia, jugador);

        assertTrue(jugador.getCreditos().equals(new Creditos(2)));
    }

    //Verificar que al pasar un turno las unidades enemigas se hayan movido según sus capacidades.
    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Jugador jugador = new Jugador(20, 100, "Julian");
        Enemigo hormiga = new Hormiga(new Coordenadas(0, 0));
        Enemigo arania = new Arania(new Coordenadas(0, 0));

        hormiga.moverse(Mapa mapa);

        // 0,0 0,1 0,2 0,3
        // 1,0 1,1 1,2 1,3
        // 2,0 2,1 2,2 2,3
        // 3,0 3,1 3,2 3,3

        // (0,0) (0,1) (0,2) (0,3) (1,0) (1,1) (1,2) (1,3) (2,0) (2,1) (2,2) (2,3) (3,0) (3,1) (3,2) (3,3)
//        pasarela.ubicar(hormiga);
//        pasarela.ubicar(arania);
//
//        camino.mover(jugador,0);
//
//        assertTrue(pasarela.estaVacia());
//
//        assertFalse(siguienteHormiga.estaVacia());
//
//        assertFalse(siguienteArania.estaVacia());
    }

    //Verificar que al eliminar todas la unidades enemigas el jugador gana el juego
//    @Test
//    public void Test10ElJugadorGanaEliminandoTodosLosEnemigos() {
//        Jugador jugador = new Jugador(20, 100, "Julian");
//        Camino camino = new Camino();
//
//        Pasarela c1 = new Pasarela(new Coordenadas(0, 0));
//        Pasarela c2 = new Pasarela(new Coordenadas(0, 1));
//        Pasarela c3 = new Pasarela(new Coordenadas(0, 2));
//        Pasarela c4 = new Pasarela(new Coordenadas(0, 3));
//        Parcela t1 = new Tierra(new Coordenadas(0, 0));
//
//        camino.agregarPasarela(c1);
//        camino.agregarPasarela(c2);
//        camino.agregarPasarela(c3);
//        camino.agregarPasarela(c4);
//
//        Enemigo enemigo = new Hormiga();
//        Defensa defensa = new TorreBlanca();
//        c1.ubicar(enemigo, jugador);
//        t1.ubicar(defensa, jugador);
//        camino.atacar(t1, jugador); // pone operativa la torre
//        camino.atacar(t1, jugador);
//
//        assertTrue(camino.gano(jugador));
//    }


    //  Verificar que sin eliminar todas la unidades enemigas, pero las pocas que
    // llegaron a la meta no alcanzan para matar al jugador, este también gana el juego.
//    @Test
//    public void Test11ElJugadorGanaEliminandoTodosLosEnemigosAunqueAlgunosLleguenALaMeta() {
//        Jugador jugador = new Jugador(20, 100, "Julian");
//        Camino camino = new Camino();
//
//        Pasarela c1 = new Pasarela(new Coordenadas(0, 0));
//        Pasarela c2 = new Pasarela(new Coordenadas(0, 1));
//        Pasarela c3 = new Pasarela(new Coordenadas(0, 2));
//        Pasarela c4 = new Pasarela(new Coordenadas(0, 3));
//
//        camino.agregarPasarela(c1);
//        camino.agregarPasarela(c2);
//        camino.agregarPasarela(c3);
//        camino.agregarPasarela(c4);
//
//        Enemigo enemigo = new Hormiga();
//        c3.ubicar(enemigo, jugador);
//
//        camino.mover(jugador,0);
//        assertFalse(camino.tieneEnemigos()); ;
//        assert((new EnergiaRoja(19)).equals(jugador.getVida()));
//        assertTrue(camino.gano(jugador));
//    }

    //    //Verificar que si las unidades enemigas llegadas a la meta matan al jugador, este pierde el juego
//    @Test
//    public void Test12ElJugadorPierdeSiLosEnemigosQueLlegaronALaMetaYLoMatan() {
//        Jugador jugador = new Jugador(1, 100, "Julian");
//        Camino camino = new Camino();
//
//        Pasarela c1 = new Pasarela(new Coordenadas(0, 0));
//        Pasarela c2 = new Pasarela(new Coordenadas(0, 1));
//        Pasarela c3 = new Pasarela(new Coordenadas(0, 2));
//        Pasarela c4 = new Pasarela(new Coordenadas(0, 3));
//
//        camino.agregarPasarela(c1);
//        camino.agregarPasarela(c2);
//        camino.agregarPasarela(c3);
//        camino.agregarPasarela(c4);
//
//        Enemigo enemigo = new Hormiga();
//        c3.ubicar(enemigo, jugador);
//
//        camino.mover(jugador,0);
//
//        assertTrue(jugador.estaMuerto());
//        assertFalse(camino.gano(jugador));
//        assertTrue(camino.perdio(jugador));
//    }
}




