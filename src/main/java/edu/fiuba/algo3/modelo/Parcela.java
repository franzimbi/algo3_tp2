package edu.fiuba.algo3.modelo;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public abstract boolean ubicar(Defensa defensa, Jugador jugador);

    public abstract boolean ubicar(Enemigo enemigo, Jugador jugador);

    public boolean defender(Parcela parcela) {
        return false;
    }
    public boolean atacado(Defensa defensa, Parcela ubicacion){
        return false;
    }

    public int distancia(Parcela other){
        return this.ubicacion.distancia(other.ubicacion);
    }

}