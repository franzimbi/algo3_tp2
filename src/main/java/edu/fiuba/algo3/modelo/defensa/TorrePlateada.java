package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.coste = new Creditos(20);
        this.armas = new TrampaArenosa(new Energia(2), 5);
        this.turnosRestantes = 2;
    }
    public String getNombre(){
        return "Torre Plateada";
    }
}
