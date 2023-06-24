package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Derecha;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class MovimientoHorizontal implements Movimiento {
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa) {
        Coordenadas posicion = enemigo.getUbicacion();
        for (int i = 0; i < velocidad.obtenerVelocidad(); i++) {
            Coordenadas aux = (new Derecha()).direccionParaCoordenada(posicion);
            enemigo.ubicarEn(aux);
        }
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
        Logger.getInstancia().info(enemigo.getNombre() +
                " se movio a (" + posicion.getX() + "," + posicion.getY() + ")");
        if (mapa.estaEnMeta(posicion)) {
            Logger.getInstancia().info(enemigo.getNombre()
                    + " llego a la meta. jugador quedo con " + jugador.getVida() + " de vida");
            enemigo.atacar(jugador, 0);
            mapa.removerEnemigo(enemigo);
        }
    }
}

