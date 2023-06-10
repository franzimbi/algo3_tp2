package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public abstract class Danio {

    protected Energia energia;
    protected Energia impar;

    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.recibirAtaque(this.energia);
    }
}
