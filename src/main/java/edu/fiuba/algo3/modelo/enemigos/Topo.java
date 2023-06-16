package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.danio.DanioTopal;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class Topo extends Enemigo {

    public Topo() {
        super();
        this.velocidad = new Velocidad(1);
        this.danio = new DanioTopal(2, 5);
        this.energia = new Energia(1);
        this.recompensa = null;

    }

    public String getNombre() {
        return "Topo";
    }

    @Override
    public void actualizarMovimientos() {
        this.movimientos += 1;
        if (movimientos == 5 || movimientos == 11) {
            velocidad.aumentarVelocidad(1);
        }
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

}
