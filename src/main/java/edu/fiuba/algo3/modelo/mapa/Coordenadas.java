package edu.fiuba.algo3.modelo.mapa;

public class Coordenadas {
    private final int x, y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
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
}
