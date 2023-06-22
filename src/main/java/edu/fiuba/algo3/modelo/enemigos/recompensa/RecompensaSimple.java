package edu.fiuba.algo3.modelo.enemigos.recompensa;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaSimple implements Recompensa {
    private int cantidadBase;

    public RecompensaSimple(int base) {
        this.cantidadBase = base;
    }

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(cantidadBase);
    }

    public void duplicarRecompensa() {
        this.cantidadBase *= 2;
    }
}
