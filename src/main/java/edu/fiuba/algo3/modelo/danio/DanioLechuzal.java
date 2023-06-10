package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.jugador.Jugador;


public class DanioLechuzal extends Danio {

    public void atacar(Jugador jugador) {jugador.destruirPrimeraDefensa();}
}
