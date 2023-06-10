package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class DanioSimple extends Danio {

    public DanioSimple(int danio) {
        this.energia = new EnergiaRoja(danio);
    }
}
