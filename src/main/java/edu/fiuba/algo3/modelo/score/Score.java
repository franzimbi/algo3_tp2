package edu.fiuba.algo3.modelo.score;

import edu.fiuba.algo3.modelo.creditos.RecompensaDobleConCheddar;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;

import java.util.ArrayList;

public class Score {

    private final ArrayList<Enemigo> muertos = new ArrayList<Enemigo>();

    public Score() {
    }

    public void recibirMuerto(Enemigo enemigo) {
        this.muertos.add(enemigo);
    }

    public void asignarCreditos(Enemigo enemigo) {
        int contador = 0;
        for (int i=0; i< muertos.size(); i++){
            if (enemigo instanceof Hormiga){
                contador++;
            }
        }
        if (contador > 10 && (enemigo instanceof Hormiga) ){
            enemigo.setRecompensa(new RecompensaDobleConCheddar(2));
        }
    }
}
