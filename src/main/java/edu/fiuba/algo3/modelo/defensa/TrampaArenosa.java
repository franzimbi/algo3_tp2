package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.logger.Logger;

public class TrampaArenosa extends Defensa {
    float multiplicador;

    public TrampaArenosa() {
        super();
        this.coste = 25;
        this.turnosRestantes = 0;
        this.vidaUtil = 3;
        this.multiplicador = 0.5f;
    }

    public String getNombre() {
        return "Trampa de arena";
    }
    @Override
    public boolean estaOperativa() {
        return this.vidaUtil > 0;
    }

    public void atacarEnemigo(Enemigo enemigo) {
        if (this.estaOperativa()) {
            enemigo.atacarEnemigo(this);
        } else {
            Logger.getInstancia().info(this.getNombre() + "no estaba operativa");
            this.turnosRestantes--;
        }
    }

    public void atacarEnemigo(Hormiga hormiga) {
        Logger.getInstancia().info("un " + this.getNombre() +
                "intenta atacar un " + hormiga.getNombre());
        this.atacar(hormiga, hormiga.distancia(this));
    }

    public void atacarEnemigo(Arania arania) {
        Logger.getInstancia().info("un " + this.getNombre() +
                "intenta atacar un " + arania.getNombre());
        this.atacar(arania, arania.distancia(this));
    }

    public void atacarEnemigo(Topo topo) {
        Logger.getInstancia().info("La " + this.getNombre() +
                "no puede atacar al " + topo.getNombre());
        this.atacar(topo, topo.distancia(this));
    }

    public void atacarEnemigo(Lechuza lechuza) {
        Logger.getInstancia().info("una " + this.getNombre() +
                "no puede relentizar una " + lechuza.getNombre());
    }

    @Override
    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            enemigo.reducirVelocidad(multiplicador);
        }
    }
}
