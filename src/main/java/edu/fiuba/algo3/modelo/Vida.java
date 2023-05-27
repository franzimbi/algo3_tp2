package edu.fiuba.algo3.modelo;

public class Vida {
    private int cantidad;

    public Vida(int cant_vida){
        this.cantidad = cant_vida;
    }

    public int cantidad(){
        return this.cantidad;
    }

    public void quitar(int danio) { this.cantidad -= danio; }
}
