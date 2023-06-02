package edu.fiuba.algo3.model.enemigos;

import edu.fiuba.algo3.model.creditos.Creditos;
import edu.fiuba.algo3.model.vida.Vida;

public class Hormiga extends Enemigo {
    public Hormiga() {
        this.vida = new Vida(1);
        this.danio = 1;
        this.velocidad = 1;
        this.creditos = new Creditos(1);
    }

    public void setCreditos(Creditos creditosNuevos) {
        this.creditos = creditosNuevos;
    }

}
