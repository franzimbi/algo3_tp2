package edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque;

import edu.fiuba.algo3.modelo.jugador.Jugador;


public abstract class Danio {

    protected int danio;

    public abstract void atacar(Jugador jugador, int cantidadDeTurnos);
}
