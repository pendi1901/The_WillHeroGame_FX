package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
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
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GameMain {
    private ArrayList<Platform> currPlatforms = new ArrayList<>();
    private ArrayList<GameObject> currGameObj = new ArrayList<>();
    private ArrayList<Integer> objOnPlatforms = new ArrayList<>();
    private Player currPlayer = null;
    private Scene myScene = null;
    private int doneTill = 4;
    private PlayMusic myMusic = null;

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

    public void newGame(){
        this.doneTill = 4;
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
    public void loadGame(){
        //Deserializing the object to
        GameResultController.Main2 object1 = null;
        try{
            FileInputStream file = new FileInputStream("demo2.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (GameResultController.Main2) in.readObject();
            in.close();
            file.close();
            System.out.println("The object has been deserialized");
            System.out.println("name = "  + object1.name1);
            System.out.println("score = "  + object1.score);
            System.out.println("coins = "  + object1.coins);
            System.out.println("weapon number =  " + object1.weaponno);
            System.out.println("current weaponindex = " + object1.currweapon);
            System.out.println("done till = " +object1.donetill1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
        }
        assert object1 != null;
        this.doneTill =object1.donetill1 ;
        this.currPlayer.setPoints(object1.score);
        this.currPlayer.setCoins(0);
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
    public void showLeaderBoard(){}
    public void startGame(){}
    public void resumeGame(){}
    public void pauseGame(){}
    public void saveGame(){}
    public void exitGame(){}

}
