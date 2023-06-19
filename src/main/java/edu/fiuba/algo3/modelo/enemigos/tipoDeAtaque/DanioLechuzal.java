package edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque;

import edu.fiuba.algo3.modelo.jugador.Jugador;


public class DanioLechuzal extends Danio {

    public DanioLechuzal() {
        this.danio = 0;
    }

    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.destruirPrimeraDefensa();
    }
}
