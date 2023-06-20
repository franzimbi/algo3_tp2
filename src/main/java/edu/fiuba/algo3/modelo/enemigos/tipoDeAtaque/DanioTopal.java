package edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class DanioTopal extends Danio {
    private final int danioPar;
    private final int danioImpar;
    public int turnos = 0;

    public DanioTopal(int danioPar, int danioImpar) {
        this.danioPar = danioPar;
        this.danioImpar = danioImpar;
    }

    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        if (cantidadDeTurnos % 2 == 0) {
            atacarDanioSegunTurno(jugador, this.danioPar);
        } else {
            atacarDanioSegunTurno(jugador, this.danioImpar);
        }
    }

    private void atacarDanioSegunTurno(Jugador jugador, int danio) {
        jugador.recibirAtaque(danio);
    }
}
