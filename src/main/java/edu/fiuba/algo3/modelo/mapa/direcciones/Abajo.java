package edu.fiuba.algo3.modelo.mapa.direcciones;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Abajo extends Direccion {
    @Override
    public Coordenadas siguiente(Coordenadas actual) {
        return new Coordenadas(actual.getX(), actual.getY()+1);
    }
}
