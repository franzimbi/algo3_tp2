package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class TrampaArenosa extends Defensa {
    float multiplicador;

    public TrampaArenosa() {
        super();
        this.coste = 25;
        this.turnosRestantes = 0;
        this.vidaUtil = 3;
        this.multiplicador = 0.5f;
    }

    public String getNombre() {
        return "Trampa de arena";
    }

    public void atacar(Lechuza lechuza, Jugador jugador){
        //"No atacamos a las lechuza, Harry Potter esta en contra de eso"
    }

    @Override
    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            enemigo.reducirVelocidad(multiplicador);
        }
    }


    public void atacar(Hormiga hormiga, int distancia) {
        if (this.estaEnRango(distancia)) {
            hormiga.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Arania arania, int distancia) {
        if (this.estaEnRango(distancia)) {
            arania.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Topo topo, int distancia) {
        if (this.estaEnRango(distancia)) {
            topo.reducirVelocidad(multiplicador);
        }
    }

    public void atacar(Lechuza lechuza) {
    }
}
