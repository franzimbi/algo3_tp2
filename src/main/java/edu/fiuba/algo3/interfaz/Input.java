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
    private final Map<String, Map<String, String>> informacion;


    private Input() {
        mapa = new HashMap<>();
        mapa.put("tierra", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/tierra.jpg")).toURI().toString()));
        mapa.put("rocoso", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/rocoso.jpg").toURI().toString())));
        mapa.put("pasarela", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/camino.jpg").toURI().toString())));
        mapa.put("meta", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/castillo.png").toURI().toString())));

        this.enemigos = new HashMap<>();
        this.enemigos.put("Arania", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/arana.png").toURI().toString())));
        this.enemigos.put("Hormiga", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/hormiga.png").toURI().toString())));
        this.enemigos.put("Topo", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/topo.png").toURI().toString())));
        this.enemigos.put("Lechuza", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/lechuza.png").toURI().toString())));

        this.defensas = new HashMap<>();
        defensas.put("Torre Blanca", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TorreBlanca.png").toURI().toString())));
        defensas.put("Torre Plateada", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TorrePlateada.png").toURI().toString())));
        defensas.put("Trampa De Arena", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/TrampaArena.jpg").toURI().toString())));
        defensas.put("noOperativa", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/noOperativa.png").toURI().toString())));

        this.mediaView = new HashMap<>();
        this.mediaView.put("musicOff", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/musicOff.png")).toURI().toString()));
        this.mediaView.put("musicOn", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/musicOn.png")).toURI().toString()));
        this.mediaView.put("questionMark", new ImageView((new File("src/main/java/edu/fiuba/algo3/resources/imagenes/questionMark.png")).toURI().toString()));

        this.mediaPlayer = new HashMap<>();
        this.mediaPlayer.put("loginMusic", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/theHorde.mp3").toURI().toString())));
        this.mediaPlayer.put("loginVideo", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/towerDefense.mp4").toURI().toString())));
        this.mediaPlayer.put("perdioVideo", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/disney.mp4").toURI().toString())));
        this.mediaPlayer.put("ganoVideo", new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/gano.mp4").toURI().toString())));

        this.informacion = new HashMap<>();
        Map<String, String> lechuza = new HashMap<>();
        lechuza.put("Energia", "5");
        lechuza.put("Velocidad", "5");
        lechuza.put("Recompensa", "0");
        lechuza.put("Info", "information:\nLa lechuza al perder\nel 50% de vida\nse mueve en\ndiagonal y\n baja la primera\ntorre del jugador");
        this.informacion.put("Lechuza", lechuza);

        Map<String, String> topo = new HashMap<>();
        topo.put("Energia", "Inmune");
        topo.put("Velocidad", "1/2/3");
        topo.put("Recompensa", "0");
        topo.put("Info", "Informacion:\naumenta su\n velocidad en 1\ncada 5 turnos\n hasta un maximo\nde 3, inmune a las\ntorres y eldanio\ndependiendo de si\nel turnos es\npar/impar (5/2)");
        this.informacion.put("Topo", topo);

        Map<String, String> hormiga = new HashMap<>();
        hormiga.put("Energia", "1");
        hormiga.put("Velocidad", "1");
        hormiga.put("Recompensa", "1");
        hormiga.put("Info", "Informacion:\nenemigo estandar");
        this.informacion.put("Hormiga", hormiga);

        Map<String, String> arania = new HashMap<>();
        arania.put("Energia", "2");
        arania.put("Velocidad", "2");
        arania.put("Recompensa", "Random");
        arania.put("Info", "Informacion:\nenemigo estandar\nsu recompensa es\nentre 0 y 10\n creditos");
        this.informacion.put("Arania", arania);

        Map<String, String> torreBlanca = new HashMap<>();
        torreBlanca.put("Costo", "10");
        torreBlanca.put("Danio", "1");
        torreBlanca.put("Rango", "3");
        torreBlanca.put("OperativaEn", "1 turno");
        torreBlanca.put("UbicarEn", "tierra");
        torreBlanca.put("Info", "Informacion:\nelimina al primer\nenemigo en rango");
        this.informacion.put("Torre Blanca", torreBlanca);

        Map<String, String> torrePlateada = new HashMap<>();
        torrePlateada.put("Costo", "20");
        torrePlateada.put("Danio", "2");
        torrePlateada.put("Rango", "5");
        torrePlateada.put("OperativaEn", "2 turnos");
        torrePlateada.put("UbicarEn", "tierra");
        torrePlateada.put("Info", "Informacion:\nelimina al primer\nenemigo en rango");
        this.informacion.put("Torre Plateada", torrePlateada);

        Map<String, String> trampaDeArena = new HashMap<>();
        trampaDeArena.put("Costo", "25");
        trampaDeArena.put("Danio", "1");
        trampaDeArena.put("Rango", "0");
        trampaDeArena.put("UbicarEn", "pasarela");
        trampaDeArena.put("OperativaEn", "0");
        trampaDeArena.put("Info", "Informacion:\ndura 3 turnos\ny reduce la velocidad\nde los enemigos\nen 1 mientras\nesten en su\n rango");
        this.informacion.put("Trampa De Arena", trampaDeArena);
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

    public String informacion(String enemigo, String campo) {
        return informacion.get(enemigo).get(campo);
    }
}


