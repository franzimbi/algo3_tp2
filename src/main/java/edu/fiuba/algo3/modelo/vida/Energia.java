package edu.fiuba.algo3.modelo.vida;

public class Energia {
    private int cantidad;
    public Energia(int cantidadVida){
        this.cantidad = cantidadVida;
    }

    public boolean equals(Energia other){
        return this.cantidad == other.cantidad;
    }

    public void reducir(Energia energiaRestada) {
        this.cantidad -= energiaRestada.cantidad;
    }

    public void aumentar(Energia extra){this.cantidad += extra.cantidad;}

    public boolean estaMuerto(){
        return (this.cantidad <= 0);
    }

}
