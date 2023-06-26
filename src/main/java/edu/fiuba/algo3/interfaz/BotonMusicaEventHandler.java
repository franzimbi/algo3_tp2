package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class BotonMusicaEventHandler implements EventHandler<ActionEvent> {

    private MediaPlayer music;
    private Button botonMusica;
    private ImageView musicaOff;
    private ImageView musicaOn;

    public BotonMusicaEventHandler(MediaPlayer musica, Button botonMusica, ImageView musicaOn, ImageView musicaOff){
        this.botonMusica = botonMusica;
        this.music = musica;
        this.musicaOn = musicaOn;
        this.musicaOff = musicaOff;

        musicaOn.setFitHeight(20);
        musicaOn.setPreserveRatio(true);
        musicaOff.setFitHeight(20);
        musicaOff.setPreserveRatio(true);

    }

    @Override
    public void handle(ActionEvent mouseEvent) {
        if (music.getStatus() == MediaPlayer.Status.PLAYING) {
          music.pause();
          botonMusica.setGraphic(musicaOff);
        } else {
           music.play();
           botonMusica.setGraphic(musicaOn);
        }
    }
}
