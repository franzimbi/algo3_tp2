package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class SistemaDeAtaque {
    protected int rango;
    protected Energia danio;


    public boolean estaEnRango(int distancia) {
        return rango >= distancia;
    }

    public abstract void atacar(Enemigo enemigo, int distancia);
}