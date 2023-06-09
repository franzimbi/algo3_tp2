package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;

public class TorreBlanca extends Defensa {

    public TorreBlanca() {
        this.coste = new Creditos(10);
        this.armas = new SistemaDeAtaque(new Energia(1), 3);
        this.turnosRestantes = 1;
    }
    public String getNombre(){
        return "Torre Blanca";
    }
}
