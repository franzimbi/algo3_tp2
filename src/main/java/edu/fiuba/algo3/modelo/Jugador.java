package edu.fiuba.algo3.modelo;

public class Jugador {
    //private static Jugador instancia = new Jugador(20, 100);
    private String nombre;
    private Vida vida;
    private Creditos creditos;

    /*public Jugador(Vida vida, Creditos creditos, String nombre) {
        this.vida = vida;
        this.creditos = creditos;
        this.nombre = nombre;
    }*/
    public Jugador(int vida, int creditos,String nombre) {
        this.nombre = nombre;
        this.vida = new Vida(vida);
        this.creditos = new Creditos(creditos);
    }
    public Vida vida() {
        return this.vida;
    }


    public int getCreditos() {
        return this.creditos.cantidad();
    }

    public void sacarCreditos(Creditos creditos) {
        this.creditos.sacarCreditos(creditos);
    }

    public boolean estaMuerto(){
        return this.vida.estaMuerto();
    }

    public void recibirDanio(Enemigo enemigo){
        this.vida.quitar(enemigo.danioGenerado());
    }
    public void recibirCreditos(Creditos creditos){

    }
}

