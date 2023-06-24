package edu.fiuba.algo3.modelo.factory;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.excepciones.EnemigoInvalidoError;

public class EnemigosFactory {
    public static Enemigo crearEnemigo(String tipoEnemigo) {
        switch (tipoEnemigo) {
            case "arana":
                return new Arania();
            case "hormiga":
                return new Hormiga();
            case "topo":
                return new Topo();
            case "lechuza":
                return new Lechuza();
            default:
                throw new EnemigoInvalidoError();
        }
    }
}
