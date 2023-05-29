package edu.fiuba.algo3.modelo;

public class Rocoso extends Parcela {
    private Coordenadas coordenadas;
    public Rocoso(Coordenadas coordenadas){
        this.coordenadas = coordenadas;
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }
    public boolean ubicar(Enemigo enemigo) {return false;}

}
