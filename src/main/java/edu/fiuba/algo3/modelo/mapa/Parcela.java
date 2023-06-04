package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;

import java.util.HashMap;
import java.util.Map;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public Parcela Parcela(String parcela, Coordenadas coordenadas){
        Map<String, Parcela> parcelasPosibles = new HashMap<>();
        parcelasPosibles.put("Tierra", new Tierra(coordenadas));
        parcelasPosibles.put("Rocoso", new Rocoso(coordenadas));
        parcelasPosibles.put("Pasarela", new Pasarela(coordenadas));

        return parcelasPosibles.get(parcela);
    }
    public abstract boolean ubicar(Defensa defensa, Jugador jugador);

    public abstract boolean ubicar(Enemigo enemigo, Jugador jugador);

    public boolean defender(Parcela parcela) {
        return false;
    }
    public boolean atacado(Defensa defensa, Parcela ubicacion){
        return false;
    }

    public int distancia(Parcela other){
        return this.ubicacion.distancia(other.ubicacion);
    }

}