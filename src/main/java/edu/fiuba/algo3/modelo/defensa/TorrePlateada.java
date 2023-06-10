package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeArena;
import edu.fiuba.algo3.modelo.ataque.SistemaDeTorre;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaAzul;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.coste = new Creditos(20);
        this.armas = new SistemaDeTorre(new EnergiaRoja(2), 5);
        this.turnosRestantes = 2;
    }
    public String getNombre(){
        return "Torre Plateada";
    }
}
