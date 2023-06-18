package edu.fiuba.algo3.modelo.mapa;

public class Coordenadas {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
    public void mover(Direccion direccion){
        this.x += direccion.enX;
        this.y += direccion.enY;
    }

}
