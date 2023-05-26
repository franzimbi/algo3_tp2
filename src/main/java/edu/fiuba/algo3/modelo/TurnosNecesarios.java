package edu.fiuba.algo3.modelo;

public class TurnosNecesarios {
    private int turnosFaltantes;

    public TurnosNecesarios(int turnos){
        this.turnosFaltantes = turnos;
    }

    public void construir(){
        if(!this.estaOperativa()){
            this.turnosFaltantes--;
        }
    }
    public boolean estaOperativa(){
        return (this.turnosFaltantes==0);
    }
}
