package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeTorre;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vidaUtil.VidaUtil;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        super();
        this.coste = new Creditos(20);
        this.armas = new SistemaDeTorre(new Energia(2), 5);
        this.turnosRestantes = 2;
        this.vidaUtil = new VidaUtil(Integer.MAX_VALUE);
    }
    public void cobrarCoste(Jugador jugador){

    }
    public String getNombre(){
        return "Torre Plateada";
    }
}
