package com.example.demo;

import java.util.ArrayList;

public class GameMain {
    private Player currPlayer;
    private ArrayList<Platform> currPlatforms;
    private int startPos = 0;
    private ArrayList<GameObject> currGameObj;
    private int startIdx;
    private int endIdx;

    GameMain(){
        currPlayer = null;
        currPlatforms = new ArrayList<>();
        startPos = 0;
        currGameObj = new ArrayList<>();
        startIdx = 0;
        endIdx = -1;
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
