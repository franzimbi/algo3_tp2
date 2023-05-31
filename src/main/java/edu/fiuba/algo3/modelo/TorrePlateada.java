package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Defensa {

    public TorrePlateada(Jugador jugador){
        this.coste = new Creditos(20);
        jugador.sacarCreditos(coste);
        this.danio = 2;
        this.turnosRestantes = 2;
        this.rango = 3;
    }

    public void atacar(){
        return;
    }
}
