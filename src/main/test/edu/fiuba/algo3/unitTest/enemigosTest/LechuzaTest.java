package edu.fiuba.algo3.unitTest.enemigosTest;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import org.junit.jupiter.api.Test;

public class LechuzaTest {

    @Test
    public void TestPasarUnTurnoMueveEnemigoSegunCapacidad() {
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(10, 1, "Julian");
        Enemigo lechuza = new Lechuza();
        Pasarela p;

        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                p= new Pasarela(new Coordenadas(i,j));
                mapa.agregarParcela(p);
            }
        }

        mapa.setMeta(new Pasarela(new Coordenadas(6,6)));
        p = new Pasarela(new Coordenadas(0,3));
        mapa.ubicar(lechuza, new Coordenadas(0,3), jugador);
        lechuza.recibirDanio(3);
        lechuza.mover(p, jugador,mapa);
    }
}
