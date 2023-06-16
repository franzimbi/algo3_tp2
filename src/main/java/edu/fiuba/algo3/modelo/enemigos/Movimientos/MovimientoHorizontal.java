package edu.fiuba.algo3.modelo.enemigos.Movimientos;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;

public class MovimientoHorizontal implements Movimiento {
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa){
        Coordenadas posicion = enemigo.getUbicacion();
        for(int i=0; i< velocidad.obtenerVelocidad(); i++){
            posicion.aumentarX();
        }
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
        Logger.getInstancia().info(enemigo.getNombre() +
                " se movio a ("+ posicion.getX() + "," + posicion.getY() + ")");
        enemigo.setDireccion(new MovimientoVertical());
    }
}

