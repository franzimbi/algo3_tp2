package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.defensa.sistemaDeDefensa.SistemaDeDefensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;


public abstract class Defensa {
    protected int vidaUtil;
    protected SistemaDeDefensa armas;
    protected int turnosRestantes;
    protected int coste;
    protected Coordenadas ubicacion;

    public Defensa() {
        this.ubicacion = new Coordenadas(0, 0);
    }

    public boolean estaOperativa() {
        return this.turnosRestantes == 0;
    }

    public void atacarEnemigo(Enemigo enemigo) {
        if (this.estaOperativa()) {
            Logger.getInstancia().info("un " + this.getNombre() +
                    "intenta atacar un " + enemigo.getNombre());
            this.armas.atacar(enemigo, enemigo.distancia(this));
            return;
        }
        Logger.getInstancia().info(this.getNombre() + "no estaba operativa");
        this.turnosRestantes--;
    }

    public void asignarAJugador(Jugador jugador) {
        jugador.sacarCreditos(this.coste);
        jugador.recibirDefensa(this);
    }

    /*public boolean estaEnRango(int distancia) {
        return this.armas.estaEnRango(distancia);
    }*/

    public abstract String getNombre();

    public boolean vidaUtil() {
        return this.vidaUtil > 0;
    }

    public void ubicarEn(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Coordenadas getUbicacion() {
        return ubicacion;
    }


}
