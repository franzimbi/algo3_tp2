package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.danio.Danio;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.excepciones.EnemigoInvalidoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemigo {
    protected Energia energia;
    protected Danio danio;
    protected Velocidad velocidad;
    protected Recompensa recompensa;
    protected int movimientos;
    protected Coordenadas ubicacion;

    public Enemigo() {
        this.movimientos = 0;
        this.ubicacion = new Coordenadas(0,0);
    }
    public static Enemigo construirEnemigo(String enemigo) {
        Map<String, Enemigo> enemigosPosibles = new HashMap<>();
        {
            enemigosPosibles.put("arana", new Arania());
            enemigosPosibles.put("hormiga", new Hormiga());
            enemigosPosibles.put("topo", new Topo());
            enemigosPosibles.put("lechuza", new Lechuza());
        }
        Enemigo aux = enemigosPosibles.get(enemigo);
        if (aux != null) {
            return aux;
        }
        throw new EnemigoInvalidoError();
    }
    public void recibirDanio(Energia danioRecibido, Jugador jugador) {
        //this.energia.reducir(danioRecibido);
        danioRecibido.reducir(this.energia);
        if (estaMuerto()) {
            Logger.getInstancia().info("un " + this.getNombre() + " murio y " +
                    "se lo envio al jugador");
            jugador.recibirMuerto(this);
            this.recompensa.otorgarRecompensa(jugador);
        }
    }

    public void ubicarEn(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void reducirVelocidad(float multiplicador) {
        this.velocidad.reducir(multiplicador);
    }
    public void setRecompensa(Recompensa nuevaRecompensa) {
        this.recompensa = nuevaRecompensa;
    }
    public boolean estaMuerto() {
        return this.energia.estaMuerto();
    }
    public int getVelocidad() {
        return velocidad.obtenerVelocidad();
    }
    public Coordenadas getUbicacion(){return this.ubicacion;}
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        this.danio.atacar(jugador, cantidadDeTurnos);
    }
    public void agregarMuerto(Score scorer) {
        scorer.agregarMuerto(this);
    }
    public abstract String getNombre();
    public void restaurarVelocidad() {
        this.velocidad.restaurar();
    }
    public void actualizarMovimientos() {
        this.movimientos += 1;
    }

    public void mover(Pasarela pasarelaActual){
        this.ubicarEn(pasarelaActual.siguientePasarela(this.velocidad));
    }
}
