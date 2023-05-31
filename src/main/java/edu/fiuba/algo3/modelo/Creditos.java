package edu.fiuba.algo3.modelo;

public class Creditos {
    private int cantidad;

    public Creditos(int cantidadCreditos){
        this.cantidad = cantidadCreditos;
    }

    public int  cantidad(){
        return this.cantidad;
    }
    public void sacarCreditos(int cantidad){
        if (this.cantidad < cantidad){
            throw new CreditosInsuficientesError();
        }
        this.cantidad -= cantidad;
    }
}
