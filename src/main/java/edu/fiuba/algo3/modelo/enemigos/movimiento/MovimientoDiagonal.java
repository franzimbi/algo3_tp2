package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.turno.Turnos;

public class MovimientoDiagonal implements Movimiento {
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa){
        Coordenadas posicion = enemigo.getUbicacion();
        for(int i=0; i< velocidad.obtenerVelocidad(); i++){
            posicion.aumentarY();
            posicion.aumentarX();
        }
        // TODO: ACA SE PONE EL ALGORITMO LOZANO.
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
    }
}

