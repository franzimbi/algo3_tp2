package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    private static int contador = 0;

    public Hormiga() {
        this.vida = new Vida(1);
    }

    private static void sumarCreditos(Jugador jugador) {
        if (contador > 10) {
            jugador.sumarCreditos(2);
        } else {
            jugador.sumarCreditos(1);
        }
    }

    public static void reiniciar() {
        contador = 0;
    }

    public void recibirDanio(int danio, Jugador jugador) {
        vida.quitar(danio);
        if (vida.estaMuerto()) {
            this.destruirse(jugador);
        }
    }

    protected void destruirse(Jugador jugador) {
        Hormiga.contador += 1;
        Hormiga.sumarCreditos(jugador);
    }
}
