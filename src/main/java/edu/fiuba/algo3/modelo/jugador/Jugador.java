package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private final Score score;
    private final ArrayList<Defensa> defensas;
    private int creditos;
    private int vida;

    public Jugador(int vida, int creditos, String nombre) {
        this.nombre = nombre;
        this.vida = vida;
        this.creditos = creditos;
        this.defensas = new ArrayList<>();
        this.score = new Score();
        Logger.getInstancia().info("Creditos iniciales de \"" + this.nombre + "\" " + this.creditos
                + " con vida inicial " + this.vida);
    }

    public int getVida() {
        return this.vida;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public void recibirAtaque(int danio) {
        this.vida -= danio;
        if (this.vida <= 0) {
            this.vida = 0;
        }
    }

    public boolean estaMuerto() {
        return this.vida <= 0;
    }

    public void recibirDefensa(Defensa defensa) {
        this.defensas.add(defensa);
    }

    public void destruirPrimeraDefensa() {
        if (this.defensas.isEmpty()) {
            Logger.getInstancia().info("no se borro una defensa de jugador porque no habia mas");
            return;
        }
        Logger.getInstancia().info("Se elimino un " + this.defensas.get(0).getNombre() + " del jugador.");
        this.defensas.remove(0);
    }

    public void recibirCreditos(int creditos) {
        this.creditos += creditos;
    }

    public void sacarCreditos(int creditos) {
        if (this.creditos < creditos) {
            Logger.getInstancia().error("Creditos insuficientes");
            throw new CreditosInsuficientesError();
        }
        this.creditos -= creditos;
        Logger.getInstancia().info("Se restaron " + creditos + " creditos. Creditos restantes: " + this.creditos);
    }

    public void recibirMuerto(Enemigo enemigo) {
        this.score.agregarMuerto(enemigo);
        enemigo.recompensar(this);
    }

    public String nombre() {
        return this.nombre;
    }

    public void atacarEnemigos(Mapa mapa) {
        for (Defensa defensa : this.defensas) {
            mapa.enemigosAtacados(defensa);
        }
    }

    public int cantidadDefensas() {
        return this.defensas.size();
    }

    public ArrayList<Defensa> getDefensas() {
        return this.defensas;
    }

    public void recolectarDefensas() {
        for (int i = 0; i < this.defensas.size(); i++) {
            this.defensas.get(i).actualizar(this);
        }
    }

    public void destruirDefensa(Defensa defensa) {
        Logger.getInstancia().info("Se elimino una " + defensa.getNombre() + " del jugador.");
        this.defensas.remove(defensa);
    }
}

