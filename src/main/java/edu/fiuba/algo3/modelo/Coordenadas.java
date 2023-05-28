package edu.fiuba.algo3.modelo;

public class Coordenadas {
    private final int x;
    private final int y;

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int distancia(Coordenadas other){
        int aux = (this.x - other.x)*(this.x - other.x) + (this.y - other.y)*(this.y - other.y);
        return (int)Math.sqrt(aux);
    }

    public int distancia (Parcela parcela){
        return parcela.distancia(this);
    }

    /*public int x(){
        return this.x;
    }

    public int y(){
        return this.y;
    }
    */
}
