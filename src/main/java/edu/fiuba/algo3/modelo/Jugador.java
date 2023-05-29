package edu.fiuba.algo3.modelo;

public class Jugador {
    private Vida vida;
    private Creditos creditos;

    public Jugador(int cant_vida, int cant_creditos){
        this.vida = new Vida(cant_vida);
        this.creditos = new Creditos(cant_creditos);
    }

    public int getVida(){
        return this.vida.cantidad();
    }

    public int obtenerCreditos(){
        return this.creditos.cantidad();
    }

    public void restarCreditos(int cantidad){
        this.creditos.restarCreditos(cantidad);
    }

    public void sumarCreditos(int cantidad){
        this.creditos.sumarCreditos(cantidad);
    }

    public void rebibirDaño(int cantidad) {
        this.vida.quitar(cantidad);
    }


}
