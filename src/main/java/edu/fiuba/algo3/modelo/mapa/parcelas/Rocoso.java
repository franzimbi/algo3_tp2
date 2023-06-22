package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Rocoso extends Parcela {

    public Rocoso(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void ubicar(Defensa defensa){
        defensa.ubicarDefensa(this);
    }

    public void ubicar(TorreBlanca torreBlanca) {
        throw new ParcelaNoPuedeUbicarError();
    }
    public void ubicar(TorrePlateada torrePlateada) {
        throw new ParcelaNoPuedeUbicarError();
    }

    public void ubicar(TrampaArenosa trampa) {
        throw new ParcelaNoPuedeUbicarError();
    }

    public void ubicar(Enemigo enemigo) {
        throw new ParcelaNoPuedeUbicarError();
    }
    public String getNombre(){return "rocoso";}
}
