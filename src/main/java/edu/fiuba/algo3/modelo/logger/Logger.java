package edu.fiuba.algo3.modelo.logger;

public class Logger {
    private boolean activado;
    private static Logger instancia = new Logger();

    private Logger() {
        this.activado = false;
    }

    public static Logger getInstancia() {
        return instancia;
    }
    public void info(String textoAImprimir){
        System.out.println(textoAImprimir);
    }
    public void error(String textoAImprimir){
        System.err.println(textoAImprimir);
    }
    public void activarLogger(){
        this.activado = true;
    }
    public void desactivarLogger(){
        this.activado = false;
    }
}