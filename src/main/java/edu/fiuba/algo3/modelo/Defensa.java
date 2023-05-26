package edu.fiuba.algo3.modelo;

public abstract class Defensa {
    protected SistemaDeAtaque sistemaDeAtaque;
    protected TurnosNecesarios turnosNecesarios;

    public static Defensa construirDefensa(String nombre){
        if (nombre.equals("torre blanca")){
            return new TorreBlanca();
        }
        return new TorrePlateada();
    }

    public boolean estaOperativa(){
        return this.turnosNecesarios.estaOperativa();
    }

    public void construir(){
        this.turnosNecesarios.construir();
    }
}
