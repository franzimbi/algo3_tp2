package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Arania extends Enemigo{

    public Arania(){
        this.vida = new Vida(2);
        this.danio = 2;
        this.velocidad = 2;

        Random rand = new Random();
        this.creditos = new Creditos(rand.nextInt(10));
    }
}