package edu.fiuba.algo3.modelo;

public abstract class Defensa {

    protected int coste;
    protected SistemaDeAtaque sistemaDeAtaque;
    protected TurnosNecesarios turnosNecesarios;
    protected Parcela parcela;

    public boolean atacar(){
        Jugador jugador = Jugador.getInstancia();
        Mapa mapa = Mapa.getInstancia();
        Enemigo objetivo = mapa.getObjetivo(this.parcela);
        int distancia = objetivo.distancia(this);
        return sistemaDeAtaque.atacar(objetivo,distancia);
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

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public int distancia(Parcela parcela){
        return this.parcela.distancia(parcela);
    }
}
