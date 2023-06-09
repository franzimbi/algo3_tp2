package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.Random;

public class RecompensaRandom implements Recompensa {

    private static final int rango = 10;

    @Override
    public void otorgarRecompensa(Jugador jugador) {
        Random rand = new Random();
        jugador.recibirCreditos(new Creditos(rand.nextInt(rango)));
    }
}
