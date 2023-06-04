package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaSimple implements Recompensa{
    private static final int cantidadBase = 1;

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(this.generarCreditos());
    }

    private Creditos generarCreditos(){
        return new Creditos(cantidadBase);
    }
}
