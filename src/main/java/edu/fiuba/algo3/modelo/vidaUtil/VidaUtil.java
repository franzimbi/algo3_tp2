package edu.fiuba.algo3.modelo.vidaUtil;

public class VidaUtil {
    private int vidaUtil;

    public VidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public boolean vidaUtil() {
        return this.vidaUtil > 0;
    }

    public void reducirVidaUtil() {
        this.vidaUtil -= 1;
    }

}
