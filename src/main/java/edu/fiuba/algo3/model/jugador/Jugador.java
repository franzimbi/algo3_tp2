package edu.fiuba.algo3.model.jugador;

import edu.fiuba.algo3.model.vida.Vida;
import edu.fiuba.algo3.model.creditos.Creditos;

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

    public void sacarCreditos(Creditos creditos) {
        this.creditos.sacarCreditos(creditos);
    }

    public Creditos creditos(){return this.creditos;}
    public boolean estaMuerto(){
        return this.vida.estaMuerto();
    }

    public void atacadoCon(Vida danio){
        this.vida.reducir(danio);
    }
    public void recibirCreditos(Creditos creditos){
        this.creditos.agregarCreditos(creditos);
    }


}

