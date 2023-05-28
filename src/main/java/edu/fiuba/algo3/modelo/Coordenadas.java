package edu.fiuba.algo3.modelo;

public class Coordenadas {
    private final int x;
    private final int y;

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int distancia(Coordenadas other){
        // Manhattan/fedex distance
        // https://en.wikipedia.org/wiki/Taxicab_geometry
        // los atributos de una instancias se pueden acceder desde otra instancia del mismo tipo
        int aux = Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        return aux;
    }

    public int distancia (Parcela parcela){
        return parcela.distancia(this);
    }
}
