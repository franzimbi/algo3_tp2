package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;


public abstract class Defensa {
    protected int vidaUtil;
    protected int turnosRestantes;
    protected int coste;
    protected Coordenadas ubicacion;
    protected int rango;
    protected int danio;

    public Defensa() {
        this.ubicacion = new Coordenadas(0, 0);
    }

    public boolean estaOperativa() {
        return this.turnosRestantes == 0;
    }

    public void actualizar(Jugador jugador) {
        if (!vidaUtil()) {
            jugador.destruirDefensa(this);
        }
    }

    public abstract void atacarEnemigo(Enemigo enemigo);

    public abstract void atacarEnemigo(Hormiga hormiga);

    public abstract void atacarEnemigo(Arania arania);

    public abstract void atacarEnemigo(Topo topo);

    public abstract void atacarEnemigo(Lechuza lechuza);

    public void asignarAJugador(Jugador jugador) {
        jugador.sacarCreditos(this.coste);
        jugador.recibirDefensa(this);
    }

    public abstract String getNombre();

    public boolean vidaUtil() {
        return this.vidaUtil > 0;
    }

    public void reducirVidaUtil() {
        this.vidaUtil--;
    }

    public void ubicarEn(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public abstract void ubicarDefensa(Parcela parcela);

    public Coordenadas getUbicacion() {
        return ubicacion;
    }

    public boolean estaEnRango(int distancia) {
        return rango >= distancia;
    }

    public void atacar(Enemigo enemigo, int distancia) {
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + enemigo.getNombre() + " recibe el daño");
            enemigo.recibirDanio(this.danio);
            return;
        }
        Logger.getInstancia().info(enemigo.getNombre() + " no estaba en rango");
    }
}
