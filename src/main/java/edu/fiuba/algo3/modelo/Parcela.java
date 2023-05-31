package edu.fiuba.algo3.modelo;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public boolean ubicar(Defensa defensa){
        return false;
    }
    public boolean ubicar(Enemigo enemigo){
        return false;
    }
    public boolean defender(Parcela parcela) {
        return false;
    }
    public boolean atacado(Defensa defensa, Coordenadas ubicacion){
        return false;
    }
}
