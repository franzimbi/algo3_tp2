package edu.fiuba.algo3.model.defensa;

import edu.fiuba.algo3.model.creditos.Creditos;
import edu.fiuba.algo3.model.vida.Vida;

public class TorreBlanca extends Defensa {

    public TorreBlanca(){
        this.coste = new Creditos(10);
        this.danio = new Vida(1);
        this.turnosRestantes = 1;
        this.rango = 3;
    }

}
