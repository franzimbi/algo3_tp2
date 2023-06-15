package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class DireccionVertical implements Direccion{
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa){
        Coordenadas posicion = enemigo.getUbicacion();
        for(int i=0; i< velocidad.obtenerVelocidad(); i++){
            posicion.aumentarY();
        }
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
        Logger.getInstancia().info(enemigo.getNombre() +
                " se movio a ("+ posicion.getX() + "," + posicion.getY() + ")");
        enemigo.setDireccion(new DireccionHorizontal());
    }
}
