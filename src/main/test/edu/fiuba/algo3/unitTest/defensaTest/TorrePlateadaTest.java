package edu.fiuba.algo3.unitTest.defensaTest;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.*;
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
        Enemigo hormiga = new Hormiga();

        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);

        assert torrePlateada.estaOperativa();
    }


    @Test
    public void Test03TorrePlateadaAtacaDentroDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();

        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test04TorrePlateadaNoAtacaFueraDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();
        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);

        hormiga.ubicarEn(new Coordenadas(0, 6));
        torrePlateada.atacarEnemigo(hormiga);
        assert !hormiga.estaMuerto();
    }

    @Test
    public void Test06TorrePlateadaPuedeMatarUnEnemigo() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();
        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);

        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void Test07TorrePlateadaMataUnEnemigoDentroDelRangoEsperado() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();
        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);

        torrePlateada.atacarEnemigo(hormiga);
        assert hormiga.estaMuerto();
    }

    @Test
    public void test08TorrePlateadaNoMataUnEnemigoFueraDeRango() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();
        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);
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

    @Test
    public void test10TorePlateadaPuedeAtacarCorrectamenteALosEnemigos() {
        Defensa torrePlateada = new TorrePlateada();
        Enemigo hormiga = new Hormiga();
        Enemigo arania = new Arania();
        Enemigo topo = new Topo();
        Enemigo lechuza = new Lechuza();

        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(hormiga);

        torrePlateada.atacarEnemigo(hormiga);
        torrePlateada.atacarEnemigo(arania);
        torrePlateada.atacarEnemigo(topo);

        for (int i = 0; i < 3; i++) {
            torrePlateada.atacarEnemigo(lechuza);
        }

        assert hormiga.estaMuerto();
        assert arania.estaMuerto();
        assert !topo.estaMuerto();
        assert lechuza.estaMuerto();
    }
}
