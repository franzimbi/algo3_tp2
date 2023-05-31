package edu.fiuba.algo3.modelo;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public abstract boolean ubicar(Defensa defensa);

    public abstract boolean ubicar(Enemigo enemigo);

    public boolean defender(Parcela parcela) {
        return false;
    }
    public boolean atacado(Defensa defensa, Coordenadas ubicacion){
        return false;
    }

}