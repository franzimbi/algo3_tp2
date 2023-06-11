package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.score.Score;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private final Energia energia;
    private final Creditos creditos;
    private final Score score;
    private final ArrayList<Parcela> defensas;

    public Jugador(int vida, int creditos, String nombre) {
        this.nombre = nombre;
        this.energia = new EnergiaRoja(vida);
        this.creditos = new Creditos(creditos);
        this.defensas = new ArrayList<Parcela>();
        this.score = new Score();
        Logger.getInstancia().info("Creditos iniciales de \"" + this.nombre + "\" " + this.creditos.getCantidad()
                + " con energia inicial " + this.energia.getCantidad());
    }

    public Energia getVida() {
        return this.energia;
    }

    public Creditos getCreditos() {
        return this.creditos;
    }

    public void recibirAtaque(Energia danio) {
        danio.reducir(this.energia);
    }

    public boolean estaMuerto() {
        return this.energia.estaMuerto();
    }

    public void recibirDefensa(Parcela defensa) {
        this.defensas.add(defensa);
    }

    public void destruirPrimeraDefensa() {
        if (this.defensas.isEmpty()) {
            return;
        }
        Parcela primeraDefensa = defensas.get(0);
        this.defensas.remove(0);
        //primeraDefensa.sacarDefensa()
    }

    public void recibirCreditos(Creditos creditos) {
        this.creditos.agregarCreditos(creditos);
    }

    public void sacarCreditos(Creditos creditos) {
        this.creditos.sacarCreditos(creditos);
    }

    public void recibirMuerto(Enemigo enemigo) {
        this.score.agregarMuerto(enemigo);
    }

    public String nombre() {
        return this.nombre;
    }
}

