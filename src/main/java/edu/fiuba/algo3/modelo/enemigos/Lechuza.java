package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.enemigos.movimiento.MovimientoDiagonal;
import edu.fiuba.algo3.modelo.enemigos.movimiento.MovimientoHorizontal;
import edu.fiuba.algo3.modelo.enemigos.movimiento.MovimientoVertical;
import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioLechuzal;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.logger.Logger;

public class Lechuza extends Enemigo {
    int energiaInicial;

    public Lechuza() {
        super();
        this.recompensa = new RecompensaSimple(0);
        this.energia = 5;
        this.energiaInicial = this.energia;
        this.danio = new DanioLechuzal();
        this.velocidad = new Velocidad(5);
        this.movimiento = new MovimientoVertical();
    }

    public String getNombre() {
        return "Lechuza";
    }

    @Override
    public void reducirVelocidad(float multiplicador) {
    }


    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.destruirPrimeraDefensa();
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        this.energia -= danioRecibido;
        if (estaMuerto()) {
            Logger.getInstancia().info("un " + this.getNombre() + " murio");
        }
        if(this.energia <= this.energiaInicial/2){
            this.movimiento = new MovimientoDiagonal();
        }
    }
}