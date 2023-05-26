package edu.fiuba.algo3.modelo;

public abstract class Defensa {

    protected int coste; //podria ser un objeto?
    protected SistemaDeAtaque sistemaDeAtaque;
    protected TurnosNecesarios turnosNecesarios;

    public static Defensa construirDefensa(String nombre, Jugador jugador){
        Defensa torre;
        if (nombre.equals("torre blanca")){
            torre = new TorreBlanca();

            jugador.restarCreditos(torre.coste());
            return torre;
        }
        torre = new TorrePlateada();

        jugador.restarCreditos(torre.coste());
        return torre;
    }

    public int coste(){
        return this.coste;
    }

    public boolean estaOperativa(){
        return this.turnosNecesarios.estaOperativa();
    }

    public void construir(){
        this.turnosNecesarios.construir();
    }
}
