package edu.fiuba.algo3.modelo;

public abstract class Parcela {
    protected Coordenadas coordenadas;

    public abstract boolean ubicar(Defensa defensa);

    public abstract boolean ubicar(Enemigo enemigo);

    public int distancia(Parcela other){
        return this.coordenadas.distancia(other);
    }

    public int distancia (Coordenadas coordenadas){
        return this.coordenadas.distancia(coordenadas);
    }

}
