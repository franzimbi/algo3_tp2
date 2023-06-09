package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.excepciones.EnemigoInvalidoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.energia.Energia;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemigo {
    protected Energia energia;
    protected Energia danio;
    protected int velocidad;
    protected Recompensa recompensa;

    public static Enemigo construirEnemigo(String enemigo) {
        Map<String, Enemigo> enemigosPosibles = new HashMap<>();
        {
            enemigosPosibles.put("arana", new Arania());
            enemigosPosibles.put("hormiga", new Hormiga());
        }
        Enemigo aux = enemigosPosibles.get(enemigo);
        if (aux != null) {
            return aux;
        }
        throw new EnemigoInvalidoError();
    }

    public void recibirDanio(Energia danioRecibido, Jugador jugador) {
        this.energia.reducir(danioRecibido);
        if (estaMuerto()) {
            Logger.getInstancia().info("un " + this.getNombre() + " murio y " +
                    "se lo envio al jugador");
            jugador.recibirMuerto(this);
            this.recompensa.otorgarRecompensa(jugador);
        }
    }

    public void setRecompensa(Recompensa nuevaRecompensa) {
        this.recompensa = nuevaRecompensa;
    }

    public boolean estaMuerto() {
        return this.energia.estaMuerto();
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.recibirAtaque(this.danio);
    }

    public void agregarMuerto(Score scorer) {
        scorer.agregarMuerto(this);
    }

    public abstract String getNombre();
}
