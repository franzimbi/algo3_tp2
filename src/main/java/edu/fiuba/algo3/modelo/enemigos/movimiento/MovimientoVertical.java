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
    public void mover(Enemigo enemigo,  Jugador jugador, Mapa mapa) {
        Coordenadas posicion;

        posicion = enemigo.getUbicacion();
        Coordenadas aux = (new Abajo()).direccionParaCoordenada(posicion);
        enemigo.ubicarEn(aux);

        mapa.dejarEnRango(aux);
        Logger.getInstancia().info(enemigo.getNombre() +
                " se movio a (" + aux.getX() + "," + aux.getY() + ")");
        if (mapa.estaEnEjeYConMeta(aux.getY())) {
            enemigo.setDireccion(new MovimientoHorizontal());
        }
    }
}
