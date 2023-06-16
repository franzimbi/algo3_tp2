package edu.fiuba.algo3.modelo.energia;

public class Energia {
    protected int cantidad;

    public Energia(int cantidadVida) {
        this.cantidad = cantidadVida;
    }

    public boolean equals(Energia other) {
        return this.cantidad == other.cantidad;
    }

    public void aumentar(Energia extra) {
        this.cantidad += extra.cantidad;
    }

    public boolean estaMuerto() {
        return (this.cantidad <= 0);
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void reducir(Energia energiaRestada) {
        this.cantidad -= energiaRestada.cantidad;
    }

}
