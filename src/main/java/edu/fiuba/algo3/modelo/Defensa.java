package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Defensa {

    protected int coste; //podria ser un objeto?
    protected SistemaDeAtaque sistemaDeAtaque;
    protected TurnosNecesarios turnosNecesarios;
    protected Parcela parcela;

    public static Defensa construirDefensa(String nombre){
        Jugador jugador = Jugador.getInstancia();
        Defensa torre;

        Map<String, Defensa> defensaPosibles = new HashMap<String, Defensa>(){{
            put("torre blanca", (new TorreBlanca()));
            put("torre plateada", (new TorrePlateada()));
        }
        };
        Defensa defensaActual =  defensaPosibles.get(nombre);
        if (defensaActual != null){
            jugador.restarCreditos(defensaActual.coste());
            return defensaActual;
        }else{
            throw new DefensaNoExisteError();
        }

    }

    public boolean atacar(){
        Jugador jugador = Jugador.getInstancia();
        Mapa mapa = Mapa.getInstancia();
        Enemigo objetivo = mapa.getObjetivo(this.parcela);
        return sistemaDeAtaque.atacar(objetivo,this);
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
