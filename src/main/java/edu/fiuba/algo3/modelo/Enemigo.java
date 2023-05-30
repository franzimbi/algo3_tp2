package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemigo {
    protected Camino camino;
    protected Vida vida;
    protected int velocidad;
    protected int danio;

    public void recibirDanio(int danio) {
        Jugador jugador = Jugador.getInstancia();
        vida.quitar(danio);
        if (vida.estaMuerto()) {
            this.destruirse();
        }
    }

    public int Vida() {
        return vida.cantidad();
    }

    public boolean estaMuerto() {
        return (vida.cantidad() == 0);
    }

    public int distancia(Parcela parcela) {
        return this.camino.distancia(parcela);
    }

    public int distancia(Defensa defensa) {
        return defensa.distancia(this.camino);
    }

    protected abstract void destruirse();

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public void mover() {
        this.camino.mover(this.velocidad, this);
    }

    public Camino getCamino() {
        return this.camino;
    }

    public void atacar() {
        Jugador jugador = Jugador.getInstancia();
        jugador.rebibirDaño(this.danio);
        this.autoDestruccion();
        this.camino.remover(this);
    }

    public void autoDestruccion() {
        Mapa mapa = Mapa.getInstancia();
        mapa.removerEnemigo(this);
    }



}




