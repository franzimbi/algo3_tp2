package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaDoble implements Recompensa {

    private int cantidadBase;
    private int multiplicador = 2;

    public RecompensaDoble(int base) {
        this.cantidadBase = multiplicador * base;
    }

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(new Creditos(cantidadBase));
    }


}
