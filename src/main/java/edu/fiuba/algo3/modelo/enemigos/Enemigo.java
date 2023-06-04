package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;

public abstract class Enemigo {
    protected Energia energia;
    protected Energia danio;
    protected int velocidad;

    protected Creditos creditos;

    public void recibirDanio(Energia danioRecibido, Jugador jugador){
        this.energia.reducir(danioRecibido);
        if (this.estaMuerto()) {
            recompensa.otorgarRecompensa(jugador);
        }
    }

    public boolean estaMuerto(){return this.energia.estaMuerto();}

    public int getVelocidad() {return velocidad;}

    public void atacar(Jugador jugador){
        jugador.atacadoCon(this.danio);
    }
    public Creditos obtenerCreditos(){
        return creditos;
    }
}
