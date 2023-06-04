package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaSimple implements Recompensa{
    private int cantidadBase;

    public RecompensaSimple(int base) {this.cantidadBase = base;}

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(this.generarCreditos());
    }

    private Creditos generarCreditos(){
        return new Creditos(this.cantidadBase);
    }
}
