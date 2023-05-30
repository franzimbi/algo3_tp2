package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Defensa {

    public TorrePlateada(){
        this.sistemaDeAtaque = new SistemaDeAtaque(2,5);
        this.turnosNecesarios = new TurnosNecesarios(2);
        this.coste = 20;
        Jugador jugador = Jugador.getInstancia();
        jugador.restarCreditos(this.coste());
    }
}
