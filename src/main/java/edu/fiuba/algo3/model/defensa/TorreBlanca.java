package edu.fiuba.algo3.model.defensa;

import edu.fiuba.algo3.model.creditos.Creditos;

public class TorreBlanca extends Defensa {

    public TorreBlanca(){
        this.coste = new Creditos(10);
        this.danio = 1;
        this.turnosRestantes = 1;
        this.rango = 3;
    }

}
