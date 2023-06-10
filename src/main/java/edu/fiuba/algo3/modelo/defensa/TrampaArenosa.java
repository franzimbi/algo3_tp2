package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeArena;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaAzul;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;

public class TrampaArenosa extends Defensa {

    public TrampaArenosa() {
        this.coste = new Creditos(25);
        this.armas = new SistemaDeArena(new EnergiaRoja(1), 0);
        this.turnosRestantes = 1;
    }
    public String getNombre(){
        return "Trampa de arena";
    }
}
