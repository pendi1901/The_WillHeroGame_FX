package com.example.demo;

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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameMain {
    private Player currPlayer = new Player("");
    private ArrayList<Platform> currPlatforms = new ArrayList<>();
    private ArrayList<GameObject> currGameObj = new ArrayList<>();
    private int startPos = 0;
    private int startIdx = 0;
    private int endIdx = -1;
    private Scene myScene = null;

    private static GameMain myGame = null;
    public static GameMain getInstance(){
        if(myGame==null){
            myGame = new GameMain();
        }
        return myGame;
    }
    private GameMain(){}

    public Player getCurrPlayer() {
        return currPlayer;
    }
    public ArrayList<Platform> getCurrPlatforms() {
        return currPlatforms;
    }
    public ArrayList<GameObject> getCurrGameObj() {
        return currGameObj;
    }
    public int getStartPos() {
        return startPos;
    }
    public int getStartIdx() {
        return startIdx;
    }
    public int getEndIdx() {
        return endIdx;
    }
    public Scene getMyScene() {
        return myScene;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }
    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }
    public void setMyScene(Scene myScene) {
        this.myScene = myScene;
    }

    public void showMainMenu(){}
    public void newGame(){
        int dist_bw_plat = 280, maxY = 240, minY = 200;
        for (int i = 0; i < 4; i++) {
            Platform newPlat = new Platform();
            newPlat.setInf(40+i*dist_bw_plat, (int)((Math.random() * (maxY - minY)) + minY), 134, 61);
            currPlatforms.add(newPlat);
        }
    }
    public void loadGame(){}
    public void showLeaderBoard(){}
    public void startGame(){

    }
    public void resumeGame(){}
    public void pauseGame(){}
    public void saveGame(){}
    public void exitGame(){}

}
