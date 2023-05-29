package edu.fiuba.algo3.modelo;

public class Jugador {
    private static Jugador instancia = new Jugador(20, 100);
    private Vida vida;
    private Creditos creditos;

    private Jugador(int cant_vida, int cant_creditos){
        this.vida = new Vida(cant_vida);
        this.creditos = new Creditos(cant_creditos);
    }

    public static Jugador getInstancia() {
        return instancia;
    }

    public int getVida(){
        return this.vida.cantidad();
    }

    public int getCreditos(){
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

    public static void reiniciar() {
        instancia = new Jugador(20, 100);
    }

    public boolean estaMuerto(){
        return this.vida.estaMuerto();
    }

}
