package edu.fiuba.algo3.modelo;

public class Creditos {
    private int cantidad;

    public Creditos(int cant_creditos){
        this.cantidad = cant_creditos;
    }

    public int cantidad(){
        return this.cantidad;
    }

    public void restarCredtios(int cantidad){
        if(cantidad > this.cantidad){
            throw new CreditosInsuficientesError();
        }
        this.cantidad -= cantidad;
    }
}
