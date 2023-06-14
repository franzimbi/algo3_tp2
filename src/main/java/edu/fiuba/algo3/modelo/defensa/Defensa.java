package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.ataque.SistemaDeAtaque;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.vidaUtil.VidaUtil;


public abstract class Defensa {
    protected VidaUtil vidaUtil;
    protected SistemaDeAtaque armas;
    protected int turnosRestantes;
    protected Creditos coste;
    protected Coordenadas ubicacion;

    public Defensa(){
        this.ubicacion = new Coordenadas(0,0);
    }
    public boolean estaOperativa() {
        return this.turnosRestantes == 0;
    }

    public void atacarEnemigo(Enemigo enemigo, Jugador jugador) {
        if (this.estaOperativa()) {
            this.armas.atacar(enemigo, jugador);
            return;
        }
        this.turnosRestantes--;
    }

    public void asignarAJugador(Jugador jugador) {
        jugador.sacarCreditos(this.coste);
        jugador.recibirDefensa(this);
    }
    public boolean estaEnRango(int distancia) {
        return this.armas.estaEnRango(distancia);
    }

    public abstract String getNombre();

    public boolean vidaUtil() {
        return this.vidaUtil.vidaUtil();
    }

    public void ubicarEn(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }
}
