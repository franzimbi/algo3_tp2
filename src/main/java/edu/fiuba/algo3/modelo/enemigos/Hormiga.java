package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.*;
import edu.fiuba.algo3.modelo.vida.Energia;

public class Hormiga extends Enemigo {

    private static final int base = 1;


    public Hormiga() {
        this.recompensa = new RecompensaSimple(this.base);
        this.energia = new Energia(1);
        this.danio = new Energia(1);
        this.velocidad = 1;

    }
}
