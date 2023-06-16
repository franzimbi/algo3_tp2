package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TorrePlateadaTest {
    @Test
    public void Test01AlCrearUnaTorrePlateadaNoEstaOperativa() {
        Defensa torrePlateada = new TorrePlateada();
        assert !torrePlateada.estaOperativa();
    }

    @Test
    public void Test02Pasado2TurnosLaTorrePlateadaEstaOperativa() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        torrePlateada.atacarEnemigo(null);
        assert torrePlateada.estaOperativa();
    }

    @Test
    public void Test03TorrePlateadaAtacaDentroDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        torrePlateada.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test04TorrePlateadaNoAtacaFueraDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        hormiga.ubicarEn(new Coordenadas(0, 6));
        torrePlateada.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void Test06TorrePlateadaPuedeMatarUnEnemigo() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        torrePlateada.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();

        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test07TorrePlateadaMataUnEnemigoDentroDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        torrePlateada.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();

        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void test08TorrePlateadaNoMataUnEnemigoFueraDeRango() {
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.atacarEnemigo(null);
        torrePlateada.atacarEnemigo(null);
        Enemigo hormiga = new Hormiga();
        hormiga.ubicarEn(new Coordenadas(0, 6));

        torrePlateada.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void test09TorrePlateadaDescuentaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(20, 100, "Jugador 1");
        Defensa torrePlateada = new TorrePlateada();
        torrePlateada.asignarAJugador(jugador);

        assertEquals(80, jugador.getCreditos());
    }
}
