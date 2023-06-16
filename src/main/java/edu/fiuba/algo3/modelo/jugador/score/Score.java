package edu.fiuba.algo3.modelo.jugador.score;

import edu.fiuba.algo3.modelo.enemigos.*;


public class Score {

    private int cantidadHormigas = 0;

    public void agregarMuerto(Enemigo enemigo) {
        enemigo.agregarMuerto(this);
    }

    public void agregarMuerto(Arania arania){}

    public void agregarMuerto(Hormiga hormiga) {
        this.cantidadHormigas++;
        if (cantidadHormigas > 10) {
            hormiga.duplicarRecompensa();
        }
    }

    public void agregarMuerto(Lechuza lechuza){

    }

    public void agregarMuerto(Topo topo){

    }
}
