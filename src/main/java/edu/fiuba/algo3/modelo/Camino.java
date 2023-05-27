package edu.fiuba.algo3.modelo;

public class Camino implements Parcela    {
    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo){
        return true;
    }
}
