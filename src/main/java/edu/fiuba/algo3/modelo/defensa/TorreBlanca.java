package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.logger.Logger;

public class TorreBlanca extends Defensa {

    public TorreBlanca() {
        super();
        this.coste = 10;
        this.turnosRestantes = 1;
        this.vidaUtil = 1;
        this.danio = 1;
        this.rango = 3;
    }

    public String getNombre(){
        return "Torre Blanca";
    }

    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + enemigo.getNombre() + " recibe el daño");
            enemigo.recibirDanioDos(this, distancia);
            return;
        }
        Logger.getInstancia().info(enemigo.getNombre() + " no estaba en rango");
    }


    public void atacar(Hormiga hormiga, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + hormiga.getNombre() + " recibe el daño");
            hormiga.recibirDanio(this.danio);
            return;
        }
        Logger.getInstancia().info(hormiga.getNombre() + " no estaba en rango");
    }


//    public void atacar(Arania arania, int distancia) {
//        Logger.getInstancia().info("un " + arania.getNombre() + " recibe el daño");
//        arania.recibirDanio(this.danio);
//
//    }
//
//    public void atacar(Topo topo, int distancia) {
//
//    }
//
//    public void atacar(Lechuza lechuza, int distancia) {
//        Logger.getInstancia().info("un " + lechuza.getNombre() + " recibe el daño");
//        lechuza.recibirDanio(this.danio);
//    }


}
