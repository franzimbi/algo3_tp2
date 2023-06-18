package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Topo;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TorreBlancaTest {

    @Test
    public void Test01AlCrearUnaTorreBlancaNoEstaOperativa() {
        Defensa torreBlanca = new TorreBlanca();
        assert !torreBlanca.estaOperativa();
    }

    @Test
    public void Test02Pasado1TurnoLaTorreBlancaEstaOperativa() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        assert torreBlanca.estaOperativa();
    }

    @Test
    public void Test03TorreBlancaAtacaDentroDelRangoEsperado() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        torreBlanca.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();

    }

    @Test
    public void Test04TorreBlancaNoAtacaFueraDelRangoEsperado() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        hormiga.ubicarEn(new Coordenadas(0, 4));
        torreBlanca.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void Test06TorreBlancaPuedeMatarUnEnemigo() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();

        torreBlanca.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test07TorreBlancaMataUnEnemigoDentroDelRangoEsperado() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();

        torreBlanca.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void test08TorreBlancaNoMataUnEnemigoFueraDeRango() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        hormiga.ubicarEn(new Coordenadas(0, 4));

        torreBlanca.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void test09TorreBlancaDescuentaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.asignarAJugador(jugador);

        assertEquals(90, jugador.getCreditos());
    }

    @Test
    public void test10ToreBlancaPuedeAtacarCorrectamenteALosEnemigos() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga(); // 1
        Enemigo arania = new Arania(); // 2
        Enemigo topo = new Topo(); // inmune
        Enemigo lechuza = new Lechuza(); // 5

        torreBlanca.atacarEnemigo(hormiga);
        torreBlanca.atacarEnemigo(arania);
        torreBlanca.atacarEnemigo(arania);
        torreBlanca.atacarEnemigo(topo);

        for (int i = 0; i < 5; i++) {
            torreBlanca.atacarEnemigo(lechuza);
        }

        assert hormiga.estaMuerto();
//        assert arania.estaMuerto();
//        assert !topo.estaMuerto();
//        assert lechuza.estaMuerto();
    }
}
