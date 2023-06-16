package edu.fiuba.algo3.modelo.defensa.sistemaDeDefensa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;

public abstract class SistemaDeDefensa {
    protected int rango;
    protected int danio;

    public boolean estaEnRango(int distancia) {
        return rango >= distancia;
    }

    public abstract void atacar(Enemigo enemigo, int distancia);
}