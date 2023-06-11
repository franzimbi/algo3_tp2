package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SistemaDeArena extends SistemaDeAtaque {
    public final float multiplicador;

    public SistemaDeArena(Energia danio, int rango, float multiplicador) {
        this.rango = rango;
        this.danio = danio;
        this.multiplicador = multiplicador;
    }

    public void atacar(Enemigo enemigo, Jugador jugador) {
        enemigo.reducirVelocidad(multiplicador);
    }
}
