package edu.fiuba.algo3.modelo.energia;

public class EnergiaRoja extends Energia {

    public EnergiaRoja(int cantidad) {
        this.cantidad = cantidad;
    }

    public void reducir(Energia energiaRestada) {
        energiaRestada.reducir(this);
    }

    public void reducir(EnergiaRoja energiaRestada) {
        this.cantidad -= energiaRestada.cantidad;
    }

    public void reducir(EnergiaAzul energiaRestada) {
        return;
    }
}