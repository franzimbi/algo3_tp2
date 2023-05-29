package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemigo {
    protected Camino camino;
    protected Vida vida;
    protected int velocidad;
    protected int danio;

    public static Enemigo crearEnemigo(String enemigo) {
        Map<String, Enemigo> enemigosPosibles = new HashMap<String, Enemigo>() {
            {
                put("Hormiga", (new Hormiga()));
                put("Arania", (new Arania()));
            }
        };
        Enemigo enemigoActual = enemigosPosibles.get(enemigo);
        if (enemigoActual != null) {
            return enemigoActual;
        } else {
            throw new EnemigoNoExisteError();
        }

    }

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
        this.recibirDanio(this.Vida());
    }

}




