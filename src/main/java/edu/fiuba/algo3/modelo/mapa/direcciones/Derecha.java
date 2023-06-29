package edu.fiuba.algo3.modelo.mapa.direcciones;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Derecha extends Direccion {
    public Coordenadas direccionParaCoordenada(Coordenadas coordenadas){
        return coordenadas.coordenadasMovidasEn(1,0);
    }
}
