package edu.fiuba.algo3.model.creditos;

import edu.fiuba.algo3.model.excepciones.CreditosInsuficientesError;

public class Creditos {
    private int cantidad;

    public Creditos(int cantidadCreditos){
        this.cantidad = cantidadCreditos;
    }

    public int  cantidad(){
        return this.cantidad;
    }

    public void sacarCreditos(Creditos creditos){
        if (this.cantidad < creditos.cantidad){
            throw new CreditosInsuficientesError();
        }
        this.cantidad -= cantidad;
    }
    public void agregarCreditos(Creditos creditos){
        this.cantidad += creditos.cantidad;
    }
}
