package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.turno.Turnos;

public class Pasarela extends Parcela {
    private Pasarela siguiente;

    public Pasarela(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
        this.siguiente = null;
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo) {
        enemigo.ubicarEn(this.ubicacion);
            Logger.getInstancia().info("se ubico un " +
                    enemigo.getNombre() + " en:(" + this.getUbicacion().getX() +
                    "," + this.getUbicacion().getY() + ")" );
        return true;
    }
    public void setSiguiente(Pasarela siguiente){
        this.siguiente = siguiente;
    }

    public void siguientePasarela(Velocidad velocidad, Enemigo enemigo, Jugador jugador, Mapa mapa){
        Pasarela actual = this;
        for(int i = 0; i < velocidad.obtenerVelocidad(); i++){
            if(actual==null){
                break;
            }
            actual = actual.siguiente;
        }
        if (actual == null){
            enemigo.atacar(jugador, 0);
            Logger.getInstancia().info(enemigo.getNombre()
                    + " llego a la meta. jugador quedo con " + jugador.getVida() + " de vida");
            mapa.removerEnemigo(enemigo);
        }else{
            enemigo.ubicarEn(actual.ubicacion);
        }
    }
    public Coordenadas ubicacion() {
        return this.ubicacion;
    }

    public String getNombre(){return "pasarela";}
}