package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Defensa {

    protected int coste; //podria ser un objeto?
    protected SistemaDeAtaque sistemaDeAtaque;
    protected TurnosNecesarios turnosNecesarios;

    public static Defensa construirDefensa(String nombre, Jugador jugador){
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
