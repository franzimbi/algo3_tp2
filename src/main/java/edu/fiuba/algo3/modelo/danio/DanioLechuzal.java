package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public class DanioLechuzal extends Danio {

    public DanioLechuzal() {
        this.energia = new Energia(0);
    }


    public void atacar(Jugador jugador, int cantidadDeTurnos) {jugador.destruirPrimeraDefensa();}
}
