package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.vida.Energia;

public class TorreBlanca extends Defensa {

    public TorreBlanca(){
        this.coste = new Creditos(10);
        this.armas = new SistemaDeAtaque(new Energia(1));
        this.turnosRestantes = 1;
        this.rango = 3;
    }

}
