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
    private Player currPlayer = null;
    private ArrayList<Platform> currPlatforms = new ArrayList<>();
    private ArrayList<GameObject> currGameObj = new ArrayList<>();
    private int startPos = 0;
    private int startIdx = 0;
    private int endIdx = -1;

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

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }
    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }

    public void showMainMenu(){}
    public void newGame(){}
    public void loadGame(){}
    public void showLeaderBoard(){}
    public void startGame(){}
    public void resumeGame(){}
    public void pauseGame(){}
    public void saveGame(){}
    public void exitGame(){}

}
