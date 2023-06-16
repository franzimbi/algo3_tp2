package edu.fiuba.algo3.modelo.enemigos.recompensas;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.Random;

public class RecompensaRandom implements Recompensa {

    private int rango;

    public RecompensaRandom(int rango) {
        this.rango = rango;
    }

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        Random rand = new Random();
        jugador.recibirCreditos(rand.nextInt(rango));
    }
}
