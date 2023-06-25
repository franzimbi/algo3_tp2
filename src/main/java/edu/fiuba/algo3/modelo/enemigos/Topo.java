package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioTopal;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class Topo extends Enemigo {
    protected int turnos;

    public Topo() {
        super();
        this.turnos = 0;
        this.velocidad = new Velocidad(1);
        this.danio = new DanioTopal(2, 5);
        this.energia = 1;
        this.recompensa = new RecompensaSimple(0);
    }

    public String getNombre() {
        return "Topo";
    }


    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    @Override
    public void mover(Parcela actual, Jugador jugador, Mapa mapa) {
        this.movimiento.mover( this,  jugador, mapa);
        this.turnos++;
        this.actualizarVelocidad();
    }

    private void actualizarVelocidad() {

        if (this.turnos == 5 || this.turnos == 11) {
            this.velocidad.aumentarVelocidad(1);
        }
    }

    public void atacarEnemigo(TorreBlanca torre) {
        torre.atacarEnemigo(this);
    }

    public void atacarEnemigo(TorrePlateada torrePlateada) {
        torrePlateada.atacarEnemigo(this);
    }

    public void atacarEnemigo(TrampaArenosa trampaArenosa) {
        trampaArenosa.atacarEnemigo(this);
    }
}
