package edu.fiuba.algo3.modelo.mapa.direcciones;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Abajo extends Direccion {
    public Coordenadas direccionParaCoordenada(Coordenadas coordenadas){
        return coordenadas.coordenadaConDireccion(this);
    }
}
