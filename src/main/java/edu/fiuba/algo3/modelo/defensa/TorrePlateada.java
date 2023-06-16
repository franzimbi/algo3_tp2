package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.defensa.sistemaDeDefensa.SistemaDeTorre;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        super();
        this.coste = 20;
        this.armas = new SistemaDeTorre(2, 5);
        this.turnosRestantes = 2;
        this.vidaUtil = 1;
    }
    public void cobrarCoste(Jugador jugador){

    }
    public String getNombre(){
        return "Torre Plateada";
    }
}
