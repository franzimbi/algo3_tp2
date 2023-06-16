package edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class DanioSimple extends Danio {

    public DanioSimple(int danio) {
        this.energia = danio;
    }

    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.recibirAtaque(this.energia);
    }
}
