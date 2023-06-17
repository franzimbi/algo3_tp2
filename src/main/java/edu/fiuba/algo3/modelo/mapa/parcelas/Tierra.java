package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Tierra extends Parcela {

    public Tierra(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void ubicar(Defensa defensa) {
        defensa.ubicarEn(this.ubicacion);
    }

    public void ubicar(Enemigo enemigo) {
        throw new ParcelaNoPuedeUbicarError();
    }

    public String getNombre(){return "tierra";}
}
