package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;

public class SistemaDeAtaque {
    private final int rango;
    protected Energia danio;

    public SistemaDeAtaque(Energia danio, int rango) {
        this.rango = rango;
        this.danio = danio;
    }

    public boolean estaEnRango(int distancia) {
        return rango >= distancia;
    }

    public void atacar(Enemigo enemigo, Jugador jugador) {
        enemigo.recibirDanio(this.danio, jugador);
    }

}
