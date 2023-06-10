package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.danio.DanioTopal;

public class Topo extends Enemigo {
    //TODO: implementar topo

    public Topo(){
        this.velocidad = 1;
        this.danio = new DanioTopal(2, 5);
    }

    public String getNombre(){
        return "Topo";
    }

}
