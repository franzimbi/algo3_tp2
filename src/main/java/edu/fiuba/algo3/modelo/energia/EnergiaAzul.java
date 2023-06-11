package edu.fiuba.algo3.modelo.energia;

public class EnergiaAzul extends Energia {
    int cantidad;

    public EnergiaAzul(int cantidad) {
        this.cantidad = cantidad;
    }


    public void reducir(Energia energiaRestada) {
        energiaRestada.reducir(this);
    }

    public void reducir(EnergiaRoja energiaRestada) {
    }

    public void reducir(EnergiaAzul energiaRestada) {
        this.cantidad -= energiaRestada.cantidad;
    }

}
