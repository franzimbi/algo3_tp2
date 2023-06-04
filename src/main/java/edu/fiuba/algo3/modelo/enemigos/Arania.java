package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.*;
import edu.fiuba.algo3.modelo.vida.*;
import edu.fiuba.algo3.modelo.jugador.*;


public class Arania extends Enemigo{

    public Arania(){
        this.recompensa = new RecompensaRandom();
        this.energia = new Energia(2);
        this.danio = new Energia(2);
        this.velocidad = 2;
    }

}