package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public abstract void ubicar(Defensa defensa);

    public abstract void ubicar(Enemigo enemigo);

    public boolean tieneUbicacion(Coordenadas other) {
        return this.ubicacion.equals(other);
    }

    public Coordenadas getUbicacion() {
        return this.ubicacion;
    }

    public boolean ubicacion(Coordenadas coordenadas) {
        return this.ubicacion.equals(coordenadas);
    }

    public abstract String getNombre();

}