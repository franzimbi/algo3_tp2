package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.defensa.sistemaDeDefensa.SistemaDeTorre;

public class TorreBlanca extends Defensa {

    public TorreBlanca() {
        super();
        this.coste = 10;
        this.armas = new SistemaDeTorre(1, 3);
        this.turnosRestantes = 1;
        this.vidaUtil = 1;
    }
    public String getNombre(){
        return "Torre Blanca";
    }
}
