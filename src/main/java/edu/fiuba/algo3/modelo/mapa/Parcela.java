package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;

import java.util.HashMap;
import java.util.Map;

public abstract class Parcela {
    protected Coordenadas ubicacion;

    public static Parcela construirParcela(String parcela, Coordenadas coordenada){
        Map<String, Parcela> parcelasPosibles = new HashMap<>();{
        parcelasPosibles.put("Tierra", new Tierra(coordenada));
        parcelasPosibles.put("Rocoso", new Rocoso(coordenada));
        parcelasPosibles.put("Pasarela", new Pasarela(coordenada));}
        Parcela aux = parcelasPosibles.get(parcela);
        if (aux != null){
            return aux;
        }
        throw new ParcelaInvalidaError();
    }
    public abstract boolean ubicar(Defensa defensa, Jugador jugador);

    public abstract boolean ubicar(Enemigo enemigo, Jugador jugador);

    public int distancia(Parcela other){
        return this.ubicacion.distancia(other.ubicacion);
    }



}