package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
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

}
