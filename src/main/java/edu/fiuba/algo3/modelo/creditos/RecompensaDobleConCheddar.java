package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaDobleConCheddar implements Recompensa{
    private int cantidadDoble;

    public RecompensaDobleConCheddar(int cantidadDoble) {this.cantidadDoble = cantidadDoble;}

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(this.generarCreditos());
    }

    private Creditos generarCreditos() {
        return new Creditos(this.cantidadDoble);
    }
}
