package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Meta;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import org.junit.jupiter.api.Test;

public class LechuzaTest {

    @Test
    public void Test01LechuzaSeIniciaEnUnestadoValido() {
        Lechuza lechuza = new Lechuza();

        assert !lechuza.estaMuerto();
        assert lechuza.getVelocidad() == 5;
    }

    @Test
    public void Test02LechuzaAlRecibirDanioSeDestruye() {
        Lechuza lechuza = new Lechuza();

        lechuza.recibirDanio(5);

        assert lechuza.estaMuerto();
    }

    @Test
    public void Test03LechuzaAtacaCorrectamente() {
        Lechuza lechuza = new Lechuza();
        Jugador jugador = new Jugador(10, 10, "juli3");

        jugador.recibirDefensa(new TorrePlateada());
        assert jugador.cantidadDefensas() == 1;

        lechuza.atacar(jugador, 0);
        assert jugador.cantidadDefensas() == 0;
    }

    @Test
    public void Test4LechuzaSeMueveCorrectamenteCon100DeVida() {
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(10, 1, "Martu");
        Enemigo lechuza = new Lechuza();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                mapa.agregarParcela(new Pasarela(new Coordenadas(i, j)));
            }
        }

        Meta meta = new Meta(new Coordenadas(6, 6));
        mapa.setMeta(meta);
        mapa.spawnear(lechuza);
        assert lechuza.getUbicacion().equals(new Coordenadas(0, 0));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(0, 5));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(4, 6));
    }

    @Test
    public void Test05LechuzaSeMueveEnDiagonalCorrectamente() {
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(10, 1, "Julian");

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                mapa.agregarParcela(new Pasarela(new Coordenadas(i, j)));
            }
        }

        mapa.setMeta(new Pasarela(new Coordenadas(15, 15)));

        Enemigo lechuza = new Lechuza();
        mapa.spawnear(lechuza);
        lechuza.recibirDanio(3);

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(5, 5));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(10, 10));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(15, 15));
    }

    @Test
    public void TestLechuzaDiagonalFalopa() {
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(10, 1, "Julian");

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                mapa.agregarParcela(new Pasarela(new Coordenadas(i, j)));
            }
        }

        mapa.setMeta(new Pasarela(new Coordenadas(15, 15)));

        Enemigo lechuza = new Lechuza();
        mapa.spawnear(lechuza);

        assert lechuza.getUbicacion().equals(new Coordenadas(0, 0));
        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(0, 5));

        lechuza.recibirDanio(3);
        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(5, 10));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(10, 12));

        mapa.mover(jugador);
        assert lechuza.getUbicacion().equals(new Coordenadas(15, 15));

    }

}
