package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeAtaque;
import edu.fiuba.algo3.modelo.ataque.SistemaDeTorre;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaAzul;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.vidaUtil.VidaUtil;

public class TorreBlanca extends Defensa {

    public TorreBlanca() {
        super();
        this.coste = new Creditos(10);
        this.armas = new SistemaDeTorre(new EnergiaRoja(1), 3);
        this.turnosRestantes = 1;
        this.vidaUtil = new VidaUtil(Integer.MAX_VALUE);
    }
    public String getNombre(){
        return "Torre Blanca";
    }
}
