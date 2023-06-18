package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioTopal;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class Topo extends Enemigo {
    protected int movimientos;
    public Topo() {
        super();
        this.movimientos=0;
        this.velocidad = new Velocidad(1);
        this.danio = new DanioTopal(2, 5);
        this.energia = 1;
        this.recompensa = new RecompensaSimple(0);
    }

    public String getNombre() {
        return "Topo";
    }

    public void actualizarMovimientos() {
        this.movimientos += 1;
        if (movimientos == 5 || movimientos == 11) {
            velocidad.aumentarVelocidad(1);
        }
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    @Override
    public void mover(Parcela actual, Jugador jugador, Mapa mapa) {
        //2
        this.movimiento.mover(velocidad, this, actual, jugador, mapa); //5
        this.actualizarMovimientos(); //7
    }
    public boolean turnoPar(){
        return this.movimientos%2 == 0;
    }

}
