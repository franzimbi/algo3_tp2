package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaDoble implements Recompensa {

    private final int cantidadDoble = 2;

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(new Creditos(cantidadDoble));
    }



}
