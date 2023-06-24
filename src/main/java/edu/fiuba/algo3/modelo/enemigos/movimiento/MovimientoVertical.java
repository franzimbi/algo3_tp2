package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Abajo;
import edu.fiuba.algo3.modelo.mapa.direcciones.Derecha;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class MovimientoVertical implements Movimiento {
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa) {
        Coordenadas posicion;
        for (int i = 0; i < velocidad.obtenerVelocidad(); i++) {
            posicion = enemigo.getUbicacion();
            if (mapa.estaEnEjeYConMeta(posicion.getY())) {
                Coordenadas aux = posicion.coordenadaConDireccion(new Derecha());
                enemigo.ubicarEn(aux);
            } else {
                Coordenadas aux = posicion.coordenadaConDireccion(new Abajo());
                enemigo.ubicarEn(aux);
            }
        }
        posicion = enemigo.getUbicacion();
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
        Logger.getInstancia().info(enemigo.getNombre() +
                " se movio a (" + posicion.getX() + "," + posicion.getY() + ")");
        if (mapa.estaEnEjeYConMeta(posicion.getY())) {
            enemigo.setDireccion(new MovimientoHorizontal());
        }
    }
}
