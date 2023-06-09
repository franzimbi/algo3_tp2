package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.scorer.Scorer;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.vida.Energia;

public class Jugador {
    private final String nombre;
    private final Energia energia;
    private final Creditos creditos;

    private final Scorer scorer;

    public Jugador(int vida, int creditos, String nombre) {
        this.nombre = nombre;
        this.energia = new Energia(vida);
        this.creditos = new Creditos(creditos);
        this.scorer = new Scorer();
    }

    public Energia getVida() {
        return this.energia;
    }

    public Creditos getCreditos() {
        return this.creditos;
    }

    public void recibirAtaque(Energia danio) {
        this.energia.reducir(danio);
    }

    public boolean estaMuerto() {
        return this.energia.estaMuerto();
    }

    public void recibirCreditos(Creditos creditos) {
        this.creditos.agregarCreditos(creditos);
    }

    public void sacarCreditos(Creditos creditos) {
        this.creditos.sacarCreditos(creditos);
    }

    public void recibirMuerto(Enemigo enemigo) { this.scorer.agregarMuerto(enemigo);}
}

