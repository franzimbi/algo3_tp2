package edu.fiuba.algo3.modelo.energia;

public abstract class Energia {
    private int cantidad;

//    public Energia(int cantidadVida) {
//        this.cantidad = cantidadVida;
//    }

    public boolean equals(Energia other) {
        return this.cantidad == other.cantidad;
    }

    public abstract void reducir(Energia energiaRestada);

    public void aumentar(Energia extra) {
        this.cantidad += extra.cantidad;
    }

    public boolean estaMuerto() {
        return (this.cantidad <= 0);
    }

    public int getCantidad(){
        return this.cantidad;
    }
}