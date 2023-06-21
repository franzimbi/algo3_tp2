package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class TorreBlanca extends Defensa {

    public TorreBlanca() {
        super();
        this.coste = 10;
        this.turnosRestantes = 1;
        this.vidaUtil = 1;
        this.danio = 1;
        this.rango = 3;
    }

    public String getNombre() {
        return "Torre Blanca";
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
    }

    public void atacarEnemigo(Lechuza lechuza) {
        Logger.getInstancia().info("un " + this.getNombre() +
                "intenta atacar un " + lechuza.getNombre());
        this.atacar(lechuza, lechuza.distancia(this));
    }

    @Override
    public void reducirVidaUtil() {

    }

    public void ubicarDefensa(Parcela parcela) {
        parcela.ubicar(this);
    }

}
