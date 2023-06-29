package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;

public class MovimientoCamino implements Movimiento {
    public void mover( Enemigo enemigo, Jugador jugador, Mapa mapa) {
        Parcela actual = mapa.encontrarParcela(enemigo.getUbicacion());
        ((Pasarela) actual).moverASiguiente(enemigo, jugador, mapa);
    }
}

