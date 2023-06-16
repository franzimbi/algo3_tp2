package edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class DanioTopal extends Danio {
    public final int impar;

    public DanioTopal(int par, int impar) {
        this.energia = par;
        this.impar = impar;
    }

    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        if (cantidadDeTurnos / 2 == 1) {
            jugador.recibirAtaque(this.impar);
        } else {
            jugador.recibirAtaque(this.energia);
        }
    }
}
