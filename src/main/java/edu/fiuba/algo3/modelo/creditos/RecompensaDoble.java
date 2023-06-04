package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaDoble implements Recompensa{
    private static final int cantidadDoble = 2;

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(this.generarCreditos());
    }

    private Creditos generarCreditos() {
        return new Creditos(cantidadDoble);
    }
}
