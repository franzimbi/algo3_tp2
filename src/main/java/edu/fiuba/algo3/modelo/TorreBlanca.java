package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Defensa {

    public TorreBlanca(Jugador jugador){
        jugador.cobrar(10);
        this.danio = 1;
        this.turnosRestantes = 1;
        this.rango = 3;

    }
}
