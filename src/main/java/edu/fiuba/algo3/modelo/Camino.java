package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Camino extends Parcela    {
    private ArrayList<Enemigo> enemigo;

    public Camino(Coordenadas coordenadas){
        this.enemigo = new ArrayList<>();
        this.coordenadas = coordenadas;
        Mapa mapa = Mapa.getInstancia();
        mapa.ubicarCamino(this);
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo){
        this.enemigo.add(enemigo);
        return true;
    }

}
