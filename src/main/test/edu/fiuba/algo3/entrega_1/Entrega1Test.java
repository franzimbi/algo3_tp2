package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Abajo;
import edu.fiuba.algo3.modelo.mapa.parcelas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    //Verificar que jugador empieza con la vida y los créditos correspondientes.
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20, 100, "mati");

        assertFalse(jugador.estaMuerto());
        assertEquals(100, jugador.getCreditos());
    }

    //Verificar que cada defensa tarde en construirse lo que dice que
    // tarda y que recién están “operativas” cuando ya se terminaron de construir.
    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto() {
        //Jugador jugador = new Jugador(20, 100, "mati");
        Enemigo enemigo = new Arania();
        Defensa torre = new TorreBlanca();

        assertFalse(torre.estaOperativa());
        torre.atacarEnemigo(enemigo);
        assertTrue(torre.estaOperativa());
    }


    //Verificar que se disponga de credito para realizar las construcciones.
    @Test
    public void Test03UnJugadorDebeTenerCreditosSuficientesParaConstruirUnaTorre() {
        Jugador jugador = new Jugador(20, 2, "A");
        Defensa torre = new TorrePlateada();

        assertThrows(CreditosInsuficientesError.class, () -> torre.asignarAJugador(jugador));
    }

    //Verificar que solo se pueda construir defensas sobre tierra (y verificar lo contrario)
    @Test
    public void Test04SoloSePuedeConstruirDefensasSobreTierra() {
        Defensa defensa = new TorreBlanca();

        Parcela tierra = new Tierra(new Coordenadas(0, 0));
        Parcela roca = new Rocoso(new Coordenadas(0, 0));
        Parcela pasarela = new Pasarela(new Coordenadas(0, 0));

        assertDoesNotThrow(() -> tierra.ubicar(defensa));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> roca.ubicar(defensa));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> pasarela.ubicar(defensa));
    }

    //Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
    @Test
    public void Test05LasDefensasAtacanDentroDelRangoEsperado() {
        //Jugador jugador = new Jugador(20, 100, "a");
        Defensa defensa = new TorreBlanca();
        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Hormiga();

        Pasarela lejos = new Pasarela(new Coordenadas(0, 5));
        Pasarela cerca = new Pasarela(new Coordenadas(0, 3));
        Tierra tierra = new Tierra(new Coordenadas(0, 1));

        cerca.ubicar(enemigo1);
        lejos.ubicar(enemigo2);
        tierra.ubicar(defensa);

        defensa.atacarEnemigo(enemigo2);
        defensa.atacarEnemigo(enemigo1); //esto pone la torre en operacion
        defensa.atacarEnemigo(enemigo1);

        assertTrue(enemigo1.estaMuerto());
        assertFalse(enemigo2.estaMuerto());
    }


    //Verificar que las unidades enemigas son dañadas acorde al ataque recibido.
    @Test
    public void Test06UnEnemigoRecibeElDanioCorrecto() {
        //Jugador jugador = new Jugador(20, 100, "a");
        Enemigo enemigo = new Arania();
        enemigo.recibirDanio(2);
        assertTrue(enemigo.estaMuerto());

    }


    //Verificar que las unidades enemigas solo se muevan por la parcela autorizada.
    @Test
    public void Test07LasUnidadesEnemigasSoloSeMuevanPorLaParcelaAutorizada() {
        Enemigo enemigo = new Arania();

        Parcela tierra = new Tierra(new Coordenadas(0, 0));
        Parcela piedra = new Rocoso(new Coordenadas(1, 0));
        Parcela pasarela = new Pasarela(new Coordenadas(1, 1));

        assertDoesNotThrow(() -> pasarela.ubicar(enemigo));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> piedra.ubicar(enemigo));
        assertThrows(ParcelaNoPuedeUbicarError.class, () -> tierra.ubicar(enemigo));
    }


    //Verificar que al destruir una unidad enemiga, el jugador cobra el crédito que le corresponde.
    @Test
    public void Test08DestruirUnEnemigoDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(10, 1, "Julian");
        Enemigo enemigo = new Hormiga();

        enemigo.recibirDanio(1);
        jugador.recibirMuerto(enemigo);

        assertEquals(2, jugador.getCreditos());
    }

    //Verificar que al pasar un turno las unidades enemigas se hayan movido según sus capacidades.
    @Test
    public void Test09PasarUnTurnoMueveEnemigoSegunCapacidad() {
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(10, 1, "Julian");
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();

        Pasarela p1 = new Pasarela(new Coordenadas(0, 0));
        Pasarela p2 = new Pasarela(new Coordenadas(0, 1));
        Pasarela p3 = new Meta(new Coordenadas(0, 2));

        p1.setSiguiente(new Abajo());
        p2.setSiguiente(new Abajo());
        mapa.agregarParcela(p3);
        mapa.agregarParcela(p1);
        mapa.agregarParcela(p2);
        mapa.agregarParcela(p3);
        hormiga.mover(p1, jugador, mapa);
        arania.mover(p1, jugador, mapa);
        assert hormiga.getUbicacion().equals(new Coordenadas(0, 1));
        assert arania.getUbicacion().equals(new Coordenadas(0, 2));
    }

    //Verificar que al eliminar todas la unidades enemigas el jugador gana el juego
    @Test
    public void Test10ElJugadorGanaEliminandoTodosLosEnemigos() {
        Jugador jugador = new Jugador(20, 100, "Julian");
        Mapa mapa = new Mapa();

        Pasarela p1 = new Pasarela(new Coordenadas(0, 0));
        Pasarela p2 = new Pasarela(new Coordenadas(0, 1));
        Pasarela p3 = new Pasarela(new Coordenadas(0, 2));
        Tierra p4 = new Tierra(new Coordenadas(1, 1));
        Meta p5 = new Meta(new Coordenadas(0, 3));

        mapa.agregarParcela(p1);
        mapa.agregarParcela(p2);
        mapa.agregarParcela(p3);
        mapa.agregarParcela(p4);
        mapa.agregarParcela(p5);

        p1.setSiguiente(new Abajo());
        p2.setSiguiente(new Abajo());
        p3.setSiguiente(new Abajo());


        Enemigo enemigo = new Hormiga();
        Defensa defensa = new TorreBlanca();
        mapa.spawnear(enemigo);
        mapa.ubicar(defensa, new Coordenadas(1, 1), jugador);

        assert !mapa.sinEnemigos();
        defensa.atacarEnemigo(enemigo);
        defensa.atacarEnemigo(enemigo);
        mapa.recolectarEnemigos(jugador);

        assert mapa.sinEnemigos();
    }


    //  Verificar que sin eliminar todas la unidades enemigas, pero las pocas que
    // llegaron a la meta no alcanzan para matar al jugador, este también gana el juego.
    @Test
    public void Test11ElJugadorGanaEliminandoTodosLosEnemigosAunqueAlgunosLleguenALaMeta() {
        Jugador jugador = new Jugador(20, 100, "Julian");
        Mapa mapa = new Mapa();

        Pasarela p1 = new Pasarela(new Coordenadas(0, 0));
        Pasarela p2 = new Pasarela(new Coordenadas(0, 1));
        Pasarela p3 = new Pasarela(new Coordenadas(0, 2));
        Tierra p4 = new Tierra(new Coordenadas(1, 1));
        Meta p5 = new Meta(new Coordenadas(0, 3));

        mapa.agregarParcela(p1);
        mapa.agregarParcela(p2);
        mapa.agregarParcela(p3);
        mapa.agregarParcela(p4);
        mapa.agregarParcela(p5);

        p1.setSiguiente(new Abajo()); //(0,0) -> (0,1)
        p2.setSiguiente(new Abajo()); //(0,1) -> (0,2)
        p3.setSiguiente(new Abajo()); //(0,2) -> (0,3)

        Defensa defensa = new TorreBlanca();

        mapa.spawnear(new Hormiga());
        mapa.spawnear(new Hormiga());
        mapa.ubicar(defensa, new Coordenadas(1, 1), jugador);

        mapa.mover(jugador);
        jugador.atacarEnemigos(mapa);
        jugador.atacarEnemigos(mapa);
        mapa.mover(jugador);
        mapa.mover(jugador);
        mapa.mover(jugador);
        mapa.recolectarEnemigos(jugador);

        assert mapa.sinEnemigos();
        assertEquals(91, jugador.getCreditos());
        assertEquals(19, jugador.getVida());
    }

    //Verificar que si las unidades enemigas llegadas a la meta matan al jugador, este pierde el juego
    @Test
    public void Test12ElJugadorPierdeSiLosEnemigosQueLlegaronALaMetaYLoMatan() {
        Jugador jugador = new Jugador(4, 100, "Julian");
        Mapa mapa = new Mapa();

        Pasarela p1 = new Pasarela(new Coordenadas(0, 0));
        Pasarela p2 = new Pasarela(new Coordenadas(0, 1));
        Pasarela p3 = new Pasarela(new Coordenadas(0, 2));
        Meta p4 = new Meta(new Coordenadas(0, 3));

        mapa.agregarParcela(p1);
        mapa.agregarParcela(p2);
        mapa.agregarParcela(p3);
        mapa.setMeta(p4);

        p1.setSiguiente(new Abajo());
        p2.setSiguiente(new Abajo());
        p3.setSiguiente(new Abajo());

        Enemigo enemigo1 = new Arania();
        Enemigo enemigo2 = new Arania();

        mapa.spawnear(enemigo1);
        mapa.spawnear(enemigo2);

        mapa.mover(jugador);
        mapa.mover(jugador);

        assert jugador.estaMuerto();

    }
}




