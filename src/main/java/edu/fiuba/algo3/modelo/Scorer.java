package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.creditos.RecompensaDoble;
import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;


public class Scorer {

    private int cantidadHormigas = 0;

    public void agregarMuerto(Enemigo enemigo) {
        enemigo.agregarMuerto(this);
    }

    public void agregarMuerto(Arania arania){
    }

    public void agregarMuerto(Hormiga hormiga) {
        this.cantidadHormigas++;
        if (cantidadHormigas > 10) {
            hormiga.setRecompensa(new RecompensaDoble());
        }
    }
}
