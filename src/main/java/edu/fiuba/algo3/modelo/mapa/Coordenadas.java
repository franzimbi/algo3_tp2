package edu.fiuba.algo3.modelo.mapa;

public class Coordenadas implements Cloneable{
    private int x;
    private int y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Coordenadas other){
        return (this.x == other.x) && (this.y == other.y);
    }
    public int distancia(Coordenadas other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Coordenadas clone() throws CloneNotSupportedException {
        return (Coordenadas) super.clone();
    }

    public void aumentarX() {
        this.x++;
    }
    public void aumentarY() {
        this.y++;
    }

    public void chequearXY(Coordenadas other) {
        if (this.x > other.x){
            this.x = other.x;
        }
        if (this.y > other.y){
            this.y = other.y;
        }
    }
}
