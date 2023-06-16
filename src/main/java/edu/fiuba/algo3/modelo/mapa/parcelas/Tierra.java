package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Tierra extends Parcela {

    public Tierra(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa) {
        defensa.ubicarEn(this.ubicacion);
        return true;
    }

    public boolean ubicar(Enemigo enemigo) {
        return false;
    }

    public String getNombre(){return "tierra";}
}
