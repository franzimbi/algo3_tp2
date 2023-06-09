package edu.fiuba.algo3.modelo.creditos;

import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;
import edu.fiuba.algo3.modelo.logger.Logger;

public class Creditos {
    private int cantidad;

    public Creditos(int cantidadCreditos) {
        this.cantidad = cantidadCreditos;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    public boolean equals(Creditos other) {
        return this.cantidad == other.cantidad;
    }

    public void sacarCreditos(Creditos creditos) {
        if (this.cantidad < creditos.cantidad) {
            Logger.getInstancia().error("Creditos insuficientes");
            throw new CreditosInsuficientesError();
        }
        this.cantidad -= creditos.cantidad;
        Logger.getInstancia().info("Se restaron " + creditos.cantidad + " creditos. Creditos restantes: " + this.cantidad);
    }

    public void agregarCreditos(Creditos creditos) {
        this.cantidad += creditos.cantidad;
        Logger.getInstancia().info("Se sumaron " + creditos.cantidad + " creditos. Creditos restantes: " + this.cantidad);
    }
}


