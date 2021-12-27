package com.example.demo;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ResourceBundle;

public class GameMain implements Serializable {
    private transient ArrayList<Platform> currPlatforms = new ArrayList<>();
    private transient ArrayList<GameObject> currGameObj = new ArrayList<>();
    private transient ArrayList<Integer> objOnPlatforms = new ArrayList<>();
    private transient MyGenericList<Pair<String,Integer>> nameWithScores = new MyGenericList<Pair<String,Integer>>();
    private Player currPlayer = null;
    private transient Scene myScene = null;
    private int doneTill = 4;
    private transient PlayMusic myMusic = null;

    private static GameMain myGame = null;
    public static GameMain getInstance(){
        if(myGame==null){
            myGame = new GameMain();
        }
        return myGame;
    }
    private GameMain(){
        // 0 - E; 1 - GO; 2 - RO; 3 - CC; 4 - WC; 5 - TNT; 6 - B,FC,P
        objOnPlatforms.addAll(Arrays.asList(
                0,0,1,3,5,2,0,1,0,
                4,2,0,3,1,5,2,0,3,
                1,4,2,5,3,1,2,0,5,
                0,1,2,4,3,5,1,2,0,
                6));
//                0,0,0,3,0,1,0,4,1,
//                0,3,1,0,0,2,4,0,1,
//                5,0,1,3,0,4,0,5,2,
//                0,0,2,0,4,1,0,5,0,
//                6));
    }

    public ArrayList<Platform> getCurrPlatforms() {
        return currPlatforms;
    }
    public ArrayList<GameObject> getCurrGameObj() {
        return currGameObj;
    }
    public Player getCurrPlayer() {
        if(currPlayer==null){
            return currPlayer = new Player("");
        }
        return currPlayer;
    }
    public Scene getMyScene() {
        return myScene;
    }
    public ArrayList<Integer> getObjOnPlatforms() {
        return objOnPlatforms;
    }
    public int getDoneTill() {
        return doneTill;
    }

    public void setMyMusic(PlayMusic myMusic) {
        this.myMusic = myMusic;
    }

    public PlayMusic getMyMusic() {
        return myMusic;
    }

    public void changeDoneTill() {
        this.doneTill += 1;
    }

    public void setMyScene(Scene myScene) {
        this.myScene = myScene;
    }

    public void iterateMyList(){
        Iterator it = currGameObj.iterator();
        while (it.hasNext()){
            System.out.println(currGameObj);
        }
    }

    public void newGame(){
        this.doneTill = 4;
        if(this.currPlayer==null){
            this.currPlayer = new Player("Tom");
        }
        this.currPlayer.setPoints(0);
        this.currPlayer.setCoins(0);
        this.currPlayer.getHero().getMyHelmet().resetWeaponCnt();
        this.currPlayer.getHero().getMyHelmet().resetSelectedIdx();
        this.getCurrPlayer().setMoveX(1);
        this.getCurrPlayer().setPrevStart(140);

        this.currPlatforms = new ArrayList<>();
        this.currGameObj = new ArrayList<>();
//        Setting platform configurations
        int dist_bw_platforms = 280, maxY = 240, minY = 200;
        for (int i = 0; i < 4; i++) {
            Platform newPlat = new Platform();
            newPlat.setInf(40+i*dist_bw_platforms, (int)((Math.random() * (maxY - minY)) + minY), 134, 61);
            currPlatforms.add(newPlat);
        }
    }

    public void showMainMenu(){}

    public void loadGame(GameMain g){
        if(g==null){
            System.out.println("not ok load game");
            this.newGame();
        }
        else {
            this.doneTill = g.getDoneTill();
            if(this.currPlayer==null){
                this.currPlayer = new Player(g.getCurrPlayer().getName());
            }
            else {
                this.currPlayer.setName(g.getCurrPlayer().getName());
            }
            this.currPlayer.setPoints(g.getCurrPlayer().getPoints());
            this.currPlayer.setCoins(g.getCurrPlayer().getCoins());
            this.currPlayer.getHero().getMyHelmet().setWeaponCntTo(g.getCurrPlayer().getHero().getMyHelmet().getWeaponCnt());
            this.currPlayer.getHero().getMyHelmet().setSelectedIdxTo(g.getCurrPlayer().getHero().getMyHelmet().getSelectedIdx());
            this.getCurrPlayer().setMoveX(1);
            this.getCurrPlayer().setPrevStart(140);

            this.currPlatforms = new ArrayList<>();
            this.currGameObj = new ArrayList<>();
//        Setting platform configurations
            int dist_bw_platforms = 280, maxY = 240, minY = 200;
            for (int i = 0; i < 4; i++) {
                Platform newPlat = new Platform();
                newPlat.setInf(40 + i * dist_bw_platforms, (int) ((Math.random() * (maxY - minY)) + minY), 134, 61);
                currPlatforms.add(newPlat);
            }
        }
    }

    public void showLeaderBoard(){}
    public void startGame(){}
    public void resumeGame(){}
    public void pauseGame(){}
    public void saveGame(){}
    public void exitGame(){}

}
