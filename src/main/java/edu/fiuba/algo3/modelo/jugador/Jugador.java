package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.vida.Energia;
import edu.fiuba.algo3.modelo.creditos.Creditos;

public class Jugador {
    //private static Jugador instancia = new Jugador(20, 100);
    private String nombre;
    private Energia energia;
    private Creditos creditos;

    /*public Jugador(Vida vida, Creditos creditos, String nombre) {
        this.vida = vida;
        this.creditos = creditos;
        this.nombre = nombre;
    }*/
    public Jugador(int vida, int creditos,String nombre) {
        this.nombre = nombre;
        this.energia = new Energia(vida);
        this.creditos = new Creditos(creditos);
    }

    public Energia vida() {
        return this.energia;
    }

    public void sacarCreditos(Creditos creditos) {
        this.creditos.sacarCreditos(creditos);
    }

    public Creditos creditos(){return this.creditos;}
    public boolean estaMuerto(){
        return this.energia.estaMuerto();
    }

    public void atacadoCon(Energia danio){
        this.energia.reducir(danio);
    }
    public void recibirCreditos(Creditos creditos){
        this.creditos.agregarCreditos(creditos);
    }


}

