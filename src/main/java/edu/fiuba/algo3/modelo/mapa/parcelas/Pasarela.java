package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.mapa.direcciones.Derecha;
import edu.fiuba.algo3.modelo.mapa.direcciones.Direccion;

public class Pasarela extends Parcela {
    protected Direccion direccion;

    public Pasarela(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
        this.direccion = new Derecha();
    }

    public void ubicar(Defensa defensa) {
        throw new ParcelaNoPuedeUbicarError();
    }

    public void ubicar(Enemigo enemigo) {
        enemigo.ubicarEn(this.ubicacion);
        Logger.getInstancia().info("se ubico un " +
                enemigo.getNombre() + " en:(" + this.getUbicacion().getX() +
                "," + this.getUbicacion().getY() + ")");
    }

    public void setSiguiente(Direccion siguiente) {
        this.direccion = siguiente;
    }

//  public void setDireccion(Direccion direccion) {this.direccion = direccion;}

//    public void siguientePasarela(Velocidad velocidad, Enemigo enemigo, Jugador jugador, Mapa mapa) {
//        Pasarela actual = this;
//
//        for (int i = 0; i < velocidad.obtenerVelocidad(); i++) {
//            if (actual==null) {
//                break;
//            }
//            actual = actual.siguiente;
////          actual = actual.direccion.siguiente(this.ubicacion);
//        }
//        if (actual == null){
//            enemigo.atacar(jugador, 0);
//            Logger.getInstancia().info(enemigo.getNombre()
//                    + " llego a la meta. jugador quedo con " + jugador.getVida() + " de vida");
//            mapa.removerEnemigo(enemigo);
//        }else{
//            enemigo.ubicarEn(actual.ubicacion);
//        }
//    }
    public void moverASiguiente(Enemigo enemigo, Jugador jugador, Mapa mapa){
        mapa.ubicar(enemigo, this.direccion.siguiente(this.ubicacion), jugador);
    }

    public String getNombre() {
        return "pasarela";
    }
}