package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        super();
        this.coste = 20;
        this.danio = 2;
        this.rango = 5;
        this.turnosRestantes = 2;
        this.vidaUtil = 1;
    }

    public String getNombre() {
        return "Torre Plateada";
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
