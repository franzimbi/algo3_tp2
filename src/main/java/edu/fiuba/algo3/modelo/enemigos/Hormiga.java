package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.energia.Energia;

public class Hormiga extends Enemigo {

    private final int recompensaBase = 1;
    public Hormiga() {
        this.recompensa = new RecompensaSimple(recompensaBase);
        this.energia = new Energia(1);
        this.danio = new Energia(1);
        this.velocidad = 1;

    }

    public void agregarMuerto(Score score){
        score.agregarMuerto(this);
    }

    public void duplicarRecompensa() {
        this.recompensa = ((RecompensaSimple) recompensa).duplicarRecompensa();
    }

    public String getNombre(){
        return "Hormiga";
    }
}
