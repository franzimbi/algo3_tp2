package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.enemigos.Lechuza;
import edu.fiuba.algo3.modelo.enemigos.Topo;
import edu.fiuba.algo3.modelo.excepciones.EnemigoInvalidoError;
import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class ParcelasFactory {
    public static Parcela crearParcela(String nombreParcela,int x, int y){
        switch (nombreParcela){
            case "Tierra":
                return new Tierra(new Coordenadas(x,y));
            case "Rocoso":
                return new Rocoso(new Coordenadas(x,y));
            case "Pasarela":
                return new Pasarela(new Coordenadas(x,y));
            case "Meta":
                return new Meta(new Coordenadas(x,y));
            default:
                throw new ParcelaInvalidaError();
        }
    }
}
