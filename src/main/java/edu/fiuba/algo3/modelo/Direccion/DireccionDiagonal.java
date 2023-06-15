package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class DireccionDiagonal implements Direccion{
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa){
        Coordenadas posicion = enemigo.getUbicacion();
        for(int i=0; i< velocidad.obtenerVelocidad(); i++){
            posicion.aumentarY();
            posicion.aumentarX();
        }
        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
    }
}

