package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import org.junit.jupiter.api.Test;

public class TorreBlancaTest {

    @Test
    public void Test01AlCrearUnaTorreBlancaNoEstaOperativa() {
        Defensa torreBlanca = new TorreBlanca();
        assert !torreBlanca.estaOperativa();
    }

    @Test
    public void Test02Pasado1TurnoLaTorreBlancaEstaOperativa() {
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null, null);
        assert torreBlanca.estaOperativa();
    }

    @Test
    public void Test03TorreBlancaAtacaDentroDelRangoEsperado() {
        Defensa torreBlanca = new TorreBlanca();
        assert torreBlanca.estaEnRango(3);
    }

    @Test
    public void Test04TorreBlancaNoAtacaFueraDelRangoEsperado() {
        Defensa torreBlanca = new TorreBlanca();
        assert !torreBlanca.estaEnRango(4);
    }

    @Test
    public void Test06TorreBlancaPuedeMatarUnEnemigo() {
        Jugador jugador = new Jugador(20, 100, "Jugador");
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.atacarEnemigo(null, jugador);
        Enemigo hormiga = new Hormiga();

        torreBlanca.atacarEnemigo(hormiga, jugador);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test07TorreBlancaMataUnEnemigoDentroDelRangoEsperado() {
        Jugador jugador = new Jugador(20, 100, "Jugador");
        Defensa torreBlanca = new TorreBlanca();
        Enemigo hormiga = new Hormiga();

        Tierra tierra = new Tierra(new Coordenadas(1, 0));
        tierra.ubicar(torreBlanca, jugador);
        Pasarela pasarela = new Pasarela(new Coordenadas(2, 0));
        pasarela.ubicar(hormiga, jugador);
        torreBlanca.atacarEnemigo(hormiga, jugador);

        assert !pasarela.estaVacia();
        tierra.atacar(pasarela, jugador);
        assert pasarela.estaVacia();
    }

    @Test
    public void test08TorreBlancaNoMataUnEnemigoFueraDeRango() {
        Jugador jugador = new Jugador(20, 100, "Jugador");
        Defensa torreBlanca = new TorreBlanca();
        Enemigo hormiga = new Hormiga();

        Tierra tierra = new Tierra(new Coordenadas(1, 0));
        tierra.ubicar(torreBlanca, jugador);
        Pasarela pasarela = new Pasarela(new Coordenadas(5, 0));
        pasarela.ubicar(hormiga, jugador);
        torreBlanca.atacarEnemigo(hormiga, jugador);

        assert !pasarela.estaVacia();
        tierra.atacar(pasarela, jugador);
        assert !pasarela.estaVacia();
    }

    @Test
    public void test09TorreBlancaDescuentaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Defensa torreBlanca = new TorreBlanca();
        torreBlanca.sacarCreditos(jugador);
        Creditos creditos = new Creditos(90);
        assert creditos.equals(jugador.getCreditos());
    }
}
