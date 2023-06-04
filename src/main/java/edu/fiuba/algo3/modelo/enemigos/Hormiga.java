package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.*;
import edu.fiuba.algo3.modelo.vida.Energia;

public class Hormiga extends Enemigo {
    public Hormiga() {
        this.energia = new Energia(1);
        this.danio = new Energia(1);
        this.velocidad = 1;
        this.creditos = new Creditos(1);
    }

    public void setCreditos(Creditos creditosNuevos) {
        this.creditos = creditosNuevos;
    }

}
