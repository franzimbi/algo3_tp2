package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    private static int contador=0;

    public Hormiga() {
        this.vida = new Vida(1);
    }
    public void recibirDanio(int danio){
        vida.quitar(danio);
    }
}
