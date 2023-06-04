package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.Random;

public class RecompensaRandom implements Recompensa{

    private int rango;

    public RecompensaRandom(int rango) {this.rango = rango;}

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        jugador.recibirCreditos(this.generarCreditos());
    }

    private Creditos generarCreditos() {
        Random rand = new Random();
        return new Creditos(rand.nextInt(this.rango));
    }
}
