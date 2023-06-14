package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeArena;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.vidaUtil.VidaUtil;

public class TrampaArenosa extends Defensa {

    public TrampaArenosa(Coordenadas ubicacion) {
        super(ubicacion);
        this.coste = new Creditos(25);
        this.armas = new SistemaDeArena(new EnergiaRoja(0), 0, 0.5f);
        this.turnosRestantes = 0;
        this.vidaUtil = new VidaUtil(3);
    }

    public String getNombre() {
        return "Trampa de arena";
    }
}
