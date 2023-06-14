package edu.fiuba.algo3.modelo.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Pasarela extends Parcela {

    public Pasarela(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo) {
        enemigo.ubicarEn(this.ubicacion);
            Logger.getInstancia().info("se ubico un " +
                    enemigo.getNombre() + " en:(" + this.getUbicacion().getX() +
                    "," + this.getUbicacion().getY() + ")" );
        return true;
    }

    public Coordenadas ubicacion() {
        return this.ubicacion;
    }

//    public void mover(Camino camino, Jugador jugador, int cantidadDeTurnos) {
//        int tam = enemigos.size();
//
//        for (int i = 0; i < tam; i++) {
//            Enemigo actual = enemigos.remove(0);
//            camino.moverEnemigo(actual, this, jugador, cantidadDeTurnos);
//        }
//    }
    public String getNombre(){return "pasarela";}
}