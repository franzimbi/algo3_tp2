package edu.fiuba.algo3.modelo.factory;

import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.*;

public class ParcelasFactory {
    public static Parcela crearParcela(String nombreParcela, int x, int y) {
        switch (nombreParcela) {
            case "Tierra":
                return new Tierra(new Coordenadas(x, y));
            case "Rocoso":
                return new Rocoso(new Coordenadas(x, y));
            case "Pasarela":
                return new Pasarela(new Coordenadas(x, y));
            case "Meta":
                return new Meta(new Coordenadas(x, y));
            default:
                throw new ParcelaInvalidaError();
        }
    }
}
