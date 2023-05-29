package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania(){
        this.vida = new Vida(2);
        this.velocidad = 2;
        this.danio = 2;
    }

    protected void destruirse(Jugador jugador){
        jugador.sumarCreditos(2);
    }
}
