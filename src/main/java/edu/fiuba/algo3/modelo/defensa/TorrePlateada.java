package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        super();
        this.coste = 20;
        this.danio = 2;
        this.rango = 5;
        this.turnosRestantes = 2;
        this.vidaUtil = 1;
    }

    public String getNombre(){
        return "Torre Plateada";
    }

    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + enemigo.getNombre() + " recibe el daño");
            enemigo.recibirDanio(this.danio);
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

    public void atacar(Arania arania, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + arania.getNombre() + " recibe el daño");
            arania.recibirDanio(this.danio);
            return;
        }
        Logger.getInstancia().info(arania.getNombre() + " no estaba en rango");
    }

    public void atacar(Topo topo, int distancia) {

    }

    public void atacar(Lechuza lechuza, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + lechuza.getNombre() + " recibe el daño");
            lechuza.recibirDanio(this.danio);
            return;
        }
        Logger.getInstancia().info(lechuza.getNombre() + " no estaba en rango");
    }
}
