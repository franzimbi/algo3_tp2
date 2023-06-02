package edu.fiuba.algo3.model;

public class Vida {
    private int cantidad;

    public Vida(int cantidadVida){
        this.cantidad = cantidadVida;
    }

    public boolean Equals(Vida other){
        return this.cantidad == other.cantidad;
    }

    public void quitar(int danio) {
        this.cantidad -= danio;
    }

    public boolean estaMuerto(){
        return (this.cantidad <= 0);
    }

    public int vida(){return this.cantidad;}
}
