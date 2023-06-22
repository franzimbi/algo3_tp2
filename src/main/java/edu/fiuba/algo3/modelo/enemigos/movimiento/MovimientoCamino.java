package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.excepciones.LlegoAMetaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;

public class MovimientoCamino implements Movimiento {
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa) {
        for (int i = 0; i < velocidad.obtenerVelocidad(); i++) {
            try {
                ((Pasarela) actual).moverASiguiente(enemigo, jugador, mapa);
                actual = mapa.encontrarParcela(enemigo.getUbicacion());
            } catch (LlegoAMetaException e) {
                break;
            }
        }
    }
}

