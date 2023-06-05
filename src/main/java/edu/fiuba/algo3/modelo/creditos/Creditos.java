package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;

public class Creditos {
    private int cantidad;

    public Creditos(int cantidadCreditos){
        this.cantidad = cantidadCreditos;
    }

    public boolean equals(Creditos other){ return this.cantidad == other.cantidad;}

    public void sacarCreditos(Creditos creditos){
        if (this.cantidad < creditos.cantidad){
            throw new CreditosInsuficientesError();
        }
        this.cantidad -= creditos.cantidad;
    }
    public void agregarCreditos(Creditos creditos){
        this.cantidad += creditos.cantidad;
    }
}


