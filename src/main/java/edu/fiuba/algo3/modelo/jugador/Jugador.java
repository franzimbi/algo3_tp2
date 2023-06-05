package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.RecompensaDoble;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.vida.Energia;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private final Energia energia;
    private final Creditos creditos;
    private final ArrayList<Enemigo> muertos = new ArrayList<>();

    public Jugador(int vida, int creditos, String nombre) {
        this.nombre = nombre;
        this.energia = new Energia(vida);
        this.creditos = new Creditos(creditos);
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

    public void recibirMuerto(Enemigo enemigo) {
        this.muertos.add(enemigo);
        this.asignarCreditos(enemigo);
    }

    public void asignarCreditos(Enemigo enemigo) {
        int contador = 0;
        for (int i = 0; i < muertos.size(); i++) {
            if (enemigo instanceof Hormiga) {
                contador++;
                if (contador > 10) {
                    enemigo.setRecompensa(new RecompensaDoble());
                    return;
                }
            }
        }
    }
}

