package edu.fiuba.algo3.modelo.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Rocoso extends Parcela {


    public Rocoso(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        return false;
    }

    public String getNombre(){return "rocoso";}
}
