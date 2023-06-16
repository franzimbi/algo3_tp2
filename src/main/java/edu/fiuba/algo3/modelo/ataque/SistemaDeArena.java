package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SistemaDeArena extends SistemaDeAtaque {
    public final float multiplicador;

    public SistemaDeArena(Energia danio, int rango, float multiplicador) {
        this.rango = rango;
        this.danio = danio;
        this.multiplicador = multiplicador;
    }

   public void atacar(Lechuza lechuza, Jugador jugador){
       //"No atacamos a las lechuza, Harry Potter esta en contra de eso"
   }

    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            enemigo.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Hormiga hormiga, int distancia) {
        if (this.estaEnRango(distancia)) {
            hormiga.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Arania arania, int distancia) {
        if (this.estaEnRango(distancia)) {
            arania.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Topo topo, int distancia) {
        if (this.estaEnRango(distancia)) {
            topo.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Lechuza lechuza) {
    }

}
