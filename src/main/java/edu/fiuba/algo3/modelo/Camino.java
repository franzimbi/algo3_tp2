package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Camino extends Parcela    {
    private ArrayList<Enemigo> enemigos;
    private Camino siguiente;

    public Camino(Coordenadas coordenadas){
        this.enemigos = new ArrayList<>();
        this.coordenadas = coordenadas;
        Mapa mapa = Mapa.getInstancia();
        mapa.ubicarCamino(this);
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo){
        this.enemigos.add(enemigo);
        enemigo.setCamino(this);
        Mapa mapa = Mapa.getInstancia();
        mapa.ubicarEnemigo(enemigo);
        return true;
    }

    public void mover(int velocidad, Enemigo enemigo) {
        if (velocidad == 0) {
            this.ubicar(enemigo);
            return;
        }
        siguiente.mover(velocidad-1,enemigo);
        this.enemigos.remove(enemigo);
    }

    public void setSiguiente(Camino siguiente) {
        this.siguiente = siguiente;
    }

}

