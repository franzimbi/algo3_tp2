package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Defensa {

    public TorreBlanca(Jugador jugador){
        this.coste = new Creditos(10);
        jugador.sacarCreditos(coste);
        this.danio = 1;
        this.turnosRestantes = 1;
        this.rango = 3;
    }

}
