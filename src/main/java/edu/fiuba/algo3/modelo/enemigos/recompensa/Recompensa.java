package edu.fiuba.algo3.modelo.enemigos.recompensa;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public interface Recompensa {

    void otorgarRecompensa(Jugador jugador);

    void duplicarRecompensa();
}
