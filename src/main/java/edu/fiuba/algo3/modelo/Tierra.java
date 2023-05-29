package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tierra extends Parcela{

    public Tierra(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean ubicar(Defensa defensa) {
        defensa.setParcela(this);
        return true;
    }

    public boolean ubicar(Enemigo enemigo) {
        return false;
    }

}

