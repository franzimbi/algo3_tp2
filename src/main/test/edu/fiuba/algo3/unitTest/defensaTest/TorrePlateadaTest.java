package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import org.junit.jupiter.api.Test;

public class TorrePlateadaTest {
//    @Test
//    public void Test01AlCrearUnaTorrePlateadaNoEstaOperativa() {
//        Defensa torrePlateada = new TorrePlateada(new Coordenadas(0,0));
//        assert !torrePlateada.estaOperativa();
//    }
//
//    @Test
//    public void Test02Pasado1TurnoLaTorrePlateadaEstaOperativa() {
//        Defensa torrePlateada = new TorrePlateada(new Coordenadas(0,0));
//        torrePlateada.atacarEnemigo(null, null);
//        torrePlateada.atacarEnemigo(null, null);
//        assert torrePlateada.estaOperativa();
//    }
//
//    @Test
//    public void Test03TorrePlateadaAtacaDentroDelRangoEsperado() {
//        Defensa torreBlanca = new TorrePlateada(new Coordenadas(0,0));
//        assert torreBlanca.estaEnRango(3);
//    }
//
//    @Test
//    public void Test04TorrePlateadaNoAtacaFueraDelRangoEsperado() {
//        Defensa torreBlanca = new TorrePlateada(new Coordenadas(0,0));
//        assert !torreBlanca.estaEnRango(6);
//    }
//
//    @Test
//    public void Test06TorrePlateadaPuedeMatarUnEnemigo() {
//        Jugador jugador = new Jugador(20, 100, "Jugador");
//        Defensa torrePlateada = new TorrePlateada(new Coordenadas(0,0));
//        Enemigo hormiga = new Hormiga(new Coordenadas(0,0));
//        torrePlateada.atacarEnemigo(hormiga, jugador);
//        torrePlateada.atacarEnemigo(hormiga, jugador);
//
//        torrePlateada.atacarEnemigo(hormiga, jugador);
//        assert hormiga.estaMuerto();
//    }
//
//    @Test
//    public void Test07TorrePlateadaMataUnEnemigoDentroDelRangoEsperado() {
//        Jugador jugador = new Jugador(20, 100, "Jugador");
//        Defensa torrePlateada = new TorrePlateada(new Coordenadas(0,0));
//        Enemigo hormiga = new Hormiga(new Coordenadas(0,0));
//
//        Tierra tierra = new Tierra(new Coordenadas(1, 0));
//        tierra.ubicar(torrePlateada, jugador);
//        Pasarela pasarela = new Pasarela(new Coordenadas(4, 0));
//        pasarela.ubicar(hormiga, jugador);
//        torrePlateada.atacarEnemigo(hormiga, jugador);
//        torrePlateada.atacarEnemigo(hormiga, jugador);
//
////        assert !pasarela.estaVacia();
////        tierra.defensaAtacar(pasarela, jugador);
////        assert pasarela.estaVacia();
//    }
//
//    @Test
//    public void test08TorrePlateadaNoMataUnEnemigoFueraDeRango() {
//        Jugador jugador = new Jugador(20, 100, "Jugador");
//        Defensa torreBlanca = new TorrePlateada(new Coordenadas(0,0));
//        Enemigo hormiga = new Hormiga(new Coordenadas(0,0));
//
//        Tierra tierra = new Tierra(new Coordenadas(1, 0));
//        tierra.ubicar(torreBlanca, jugador);
//        Pasarela pasarela = new Pasarela(new Coordenadas(5, 0));
//        pasarela.ubicar(hormiga, jugador);
//        torreBlanca.atacarEnemigo(hormiga, jugador);
//
////        assert !pasarela.estaVacia();
////        tierra.defensaAtacar(pasarela, jugador);
////        assert !pasarela.estaVacia();
//    }
//
//    @Test
//    public void test09TorrePlateadaDescuentaLosCreditosCorrectos() {
//        Jugador jugador = new Jugador(20, 100, "Jugador 1");
//        Defensa torrePlateada = new TorrePlateada(new Coordenadas(0,0));
//        torrePlateada.asignarJugador(jugador);
//        Creditos creditos = new Creditos(80);
//        assert creditos.equals(jugador.getCreditos());
//    }
}
