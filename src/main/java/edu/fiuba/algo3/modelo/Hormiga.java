package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Hormiga extends Enemigo{
    public Hormiga(){
        this.vida = new Vida(1);
        this.danio = 1;
        this.velocidad = 1;
        this.creditos = new Creditos(1);
    }
    public void setCreditos(Creditos creditosNuevos){
        this.creditos = creditosNuevos;
    }

}
