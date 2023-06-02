package edu.fiuba.algo3.model.vida;

public class Vida {
    private int cantidad;

    public Vida(int cantidadVida){
        this.cantidad = cantidadVida;
    }

    public boolean equals(Vida other){
        return this.cantidad == other.cantidad;
    }

    public void reducir(Vida vidaRestada) {
        this.cantidad -= vidaRestada.cantidad;
    }

    public void aumentar(Vida extra){this.cantidad += extra.cantidad;}

    public boolean estaMuerto(){
        return (this.cantidad <= 0);
    }

}
