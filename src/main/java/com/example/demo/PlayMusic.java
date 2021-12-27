package com.example.demo;
import java.io.File;
import java.io.Serializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayMusic implements Serializable {
    private String song;
    private Media hit;
    MediaPlayer mediaPlayer;
    PlayMusic(String name){
        this.song = name;
    }
    public void play(){
        this.hit = new Media(new File(this.song).toURI().toString());
        this.mediaPlayer = new MediaPlayer(this.hit);
        this.mediaPlayer.play();
    }
    public void stop(){
        this.mediaPlayer.stop();
    }
}
