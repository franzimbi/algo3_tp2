package edu.fiuba.algo3.modelo.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;

public class Pasarela extends Parcela {

    public Pasarela(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        Logger.getInstancia().info("se agrego un " +
                enemigo.getNombre() + " en:(" + this.getUbicacion().getX() +
                "," + this.getUbicacion().getY() + ")" );
        enemigos.add(enemigo);
        return true;
    }

    public Coordenadas ubicacion() {
        return this.ubicacion;
    }

    public void mover(Camino camino, Jugador jugador, int cantidadDeTurnos) {
        int tam = enemigos.size();

        for (int i = 0; i < tam; i++) {
            Enemigo actual = enemigos.remove(0);
            camino.moverEnemigo(actual, this, jugador, cantidadDeTurnos);
        }
    }

    public boolean estaVacia() {
        return this.enemigos.isEmpty();
    }

    public int cantidadEnemigos() {
        return this.enemigos.size();
    }

    public String getNombre(){return "pasarela";}
}