package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public abstract class Danio {

    protected Energia energia;

    public abstract void atacar(Jugador jugador, int cantidadDeTurnos);
}
