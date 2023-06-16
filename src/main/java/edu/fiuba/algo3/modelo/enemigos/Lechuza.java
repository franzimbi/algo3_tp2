package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.enemigos.Movimientos.MovimientoHorizontal;
import edu.fiuba.algo3.modelo.enemigos.recompensas.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioLechuzal;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;

public class Lechuza extends Enemigo {
    //TODO: implementar lechuza

    public Lechuza() {
        super();
        this.recompensa = new RecompensaSimple(0);
        this.energia = 5;
        this.danio = new DanioLechuzal();
        this.velocidad = new Velocidad(5);
        this.direccion = new MovimientoHorizontal();
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

//    @Override
//    public void mover(Parcela actual, Jugador jugador, Mapa mapa){
////        if (this.energia > (new EnergiaRoja(5))) {
////
////        }
////        Coordenadas posicionMeta = mapa.meta();
//
//    }
}
