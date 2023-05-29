package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Arania extends Enemigo {
    private static int contador = 0;
    public Arania(){
        this.vida = new Vida(2);
        this.velocidad = 2;
        this.danio = 2;
    }

    private static void sumarCreditos() {
        Jugador jugador = Jugador.getInstancia();
        Random randomNum = new Random();

        jugador.sumarCreditos( randomNum.nextInt(10));
    }

    protected void destruirse() {
        Arania.contador -= 2;
        Arania.sumarCreditos();
    }


}
