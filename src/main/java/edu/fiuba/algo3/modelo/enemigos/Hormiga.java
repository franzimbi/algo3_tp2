package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.enemigos.recompensas.Recompensa;
import edu.fiuba.algo3.modelo.enemigos.recompensas.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioSimple;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;

public class Hormiga extends Enemigo {

    public Hormiga() {
        super();
        int recompensaBase = 1;
        this.recompensa = new RecompensaSimple(recompensaBase);
        this.energia = 1;
        this.danio = new DanioSimple(1);
        this.velocidad = new Velocidad(1);
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public void duplicarRecompensa() {
        ((RecompensaSimple) this.recompensa).duplicarRecompensa();
    }

    public String getNombre() {
        return "Hormiga";
    }


}
