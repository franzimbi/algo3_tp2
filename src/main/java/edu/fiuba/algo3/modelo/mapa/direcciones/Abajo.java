package edu.fiuba.algo3.modelo.mapa.direcciones;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Abajo extends Direc{
    @Override
    public Coordenadas siguiente(Coordenadas actual) {
        return new Coordenadas(actual.getX()+1, actual.getY()+1);
    }
}
