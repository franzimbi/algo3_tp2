package edu.fiuba.algo3.modelo;

public class Jugador {
    //private static Jugador instancia = new Jugador(20, 100);
    private String nombre;
    private Vida vida;
    private Creditos creditos;

    public Jugador(Vida vida, Creditos creditos, String nombre) {
        this.vida = vida;
        this.creditos = creditos;
        this.nombre = nombre;
    }

    public Jugador(String nombre) {
        this.vida = new Vida(20);
        this.creditos = new Creditos(100);
    }

    public Vida vida() {
        return this.vida;
    }


    public int getCreditos() {
        return this.creditos.cantidad();
    }

    public  void cobrar(int cantidad) {
        this.creditos.sacarCreditos(cantidad);
    }

    public boolean estaMuerto(){
        return this.vida.estaMuerto();
    }

    public void recibirDanio(Enemigo enemigo){
        this.vida.quitar(enemigo.danioGenerado());
    }
}

