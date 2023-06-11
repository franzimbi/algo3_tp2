package edu.fiuba.algo3.modelo.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Parcela {
    protected Coordenadas ubicacion;
    protected ArrayList<Enemigo> enemigos = new ArrayList<>();
    protected Defensa defensa;

    public static Parcela construirParcela(String parcela, Coordenadas coordenada) {
        Map<String, Parcela> parcelasPosibles = new HashMap<>();
        {
            parcelasPosibles.put("Tierra", new Tierra(coordenada));
            parcelasPosibles.put("Rocoso", new Rocoso(coordenada));
            parcelasPosibles.put("Pasarela", new Pasarela(coordenada));
        }
        Parcela aux = parcelasPosibles.get(parcela);
        if (aux != null) {
            return aux;
        }
        throw new ParcelaInvalidaError();
    }

    public abstract boolean ubicar(Defensa defensa, Jugador jugador);

    public abstract boolean ubicar(Enemigo enemigo, Jugador jugador);

    public int distancia(Parcela other) {
        return this.ubicacion.distancia(other.ubicacion);
    }
    public Coordenadas getUbicacion(){
        return this.ubicacion;
    }

    public void defensaAtacar(Pasarela pasarela, Jugador jugador) {
        int distancia = this.distancia(pasarela);

        if (this.defensa.estaEnRango(distancia)) {
            pasarela.enemigoRecibirAtaque(this.defensa, jugador);
        }

        if (!this.defensa.vidaUtil()) {
            this.defensa = null;
        }
    }

    public void enemigoRecibirAtaque(Defensa defensa, Jugador jugador) {
        if (enemigos.isEmpty()) {
            return;
        }
        Enemigo primerEnemigo = enemigos.get(0);
        defensa.atacarEnemigo(primerEnemigo, jugador);
        if (primerEnemigo.estaMuerto()) {
            jugador.recibirMuerto(primerEnemigo);
            enemigos.remove(primerEnemigo);
        }
    }

}