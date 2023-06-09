package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.Scorer;
import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.vida.Energia;

public class Hormiga extends Enemigo {

    private final int recompensaBase = 1;
    public Hormiga() {
        this.recompensa = new RecompensaSimple();
        this.energia = new Energia(1);
        this.danio = new Energia(1);
        this.velocidad = 1;

    }

    public void agregarMuerto(Scorer score){
        score.agregarMuerto(this);
    }

}
