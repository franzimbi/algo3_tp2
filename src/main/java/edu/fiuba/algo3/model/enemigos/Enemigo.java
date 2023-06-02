package edu.fiuba.algo3.model.enemigos;

import edu.fiuba.algo3.model.creditos.Creditos;
import edu.fiuba.algo3.model.defensa.Defensa;
import edu.fiuba.algo3.model.jugador.Jugador;
import edu.fiuba.algo3.model.vida.Vida;

public abstract class Enemigo {
    protected Vida vida;
    protected Vida danio;
    protected int velocidad;

    protected Creditos creditos;

    public void recibirDanio(Defensa defensa){
        this.vida.reducir(defensa.danioGenerado());
    }

    public boolean estaMuerto(){return this.vida.estaMuerto();}

    public int getVelocidad() {return velocidad;}

    public void atacar(Jugador jugador){
        jugador.atacadoCon(this.danio);
    }
    public Creditos obtenerCreditos(){
        return creditos;
    }
}
