package edu.fiuba.algo3.interfaz;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Input {
    private static final Input instance = new Input();
    private final Map<String, ImageView> mapa;
    private final Map<String, ImageView> enemigos;
    private final Map<String, ImageView> defensas;
    private final Map<String, ImageView> mediaView;
    private final Map<String, MediaPlayer> mediaPlayer;

    private Input() {
        mapa = new HashMap<>();
        mapa.put("tierra", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/tierra.jpg")).toURI().toString()));
        mapa.put("rocoso", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/rocoso.jpg").toURI().toString())));
        mapa.put("pasarela", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/camino.jpg").toURI().toString())));

        this.enemigos = new HashMap<>();
        this.enemigos.put("Arania", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/arana.png").toURI().toString())));
        this.enemigos.put("Hormiga", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/hormiga.png").toURI().toString())));
        this.enemigos.put("Topo", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/topo.png").toURI().toString())));
        this.enemigos.put("Lechuza", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/lechuza.png").toURI().toString())));

        this.defensas = new HashMap<>();
        defensas.put("Torre Blanca", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TorreBlanca.png").toURI().toString())));
        defensas.put("Torre Plateada", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TorrePlateada.png").toURI().toString())));
        defensas.put("Trampa De Arena", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TrampaArena.png").toURI().toString())));

        this.mediaView = new HashMap<>();
        this.mediaView.put("musicOff", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/musicOff.png")).toURI().toString()));
        this.mediaView.put("musicOn", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/musicOn.png")).toURI().toString()));
        this.mediaView.put("questionMark", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/questionMark.png")).toURI().toString()));

        this.mediaPlayer = new HashMap<>();
        this.mediaPlayer.put("loginMusic", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/theHorde.mp3").toURI().toString())));
        this.mediaPlayer.put("loginVideo", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/towerDefense.mp4").toURI().toString())));
    }

    public static Input getInstance() {
        return instance;
    }

    public ImageView imagenEnemigo(String enemigo) {
        return enemigos.get(enemigo);
    }

    public ImageView imagenParcela(String parcela) {
        return mapa.get(parcela);
    }

    public ImageView imagenDefensa(String defensa) {
        return defensas.get(defensa);
    }

    public ImageView media(String media) {
        return this.mediaView.get(media);
    }

    public MediaPlayer mediaPlayer(String loginMusic) {
        return this.mediaPlayer.get(loginMusic);
    }
}


