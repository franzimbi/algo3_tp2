package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.danio.DanioSimple;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class Hormiga extends Enemigo {

    public Hormiga() {
        super();
        int recompensaBase = 1;
        this.recompensa = new RecompensaSimple(recompensaBase);
        this.energia = new EnergiaRoja(1);
        this.danio = new DanioSimple(1);
        this.velocidad = new Velocidad(1);
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public void duplicarRecompensa() {
        this.recompensa = ((RecompensaSimple) recompensa).duplicarRecompensa();
    }

    public String getNombre() {
        return "Hormiga";
    }
}
