package com.example.demo;

import java.io.Serializable;

public class Player implements Serializable {
    //need to add helmet and hero attributes
    private int points;
    private int coins;
    private int highscore;
    private String name;

    Player(String name){
        this.points = 0;
        this.highscore=0;
        this.coins=0;
        this.name = name;
    }
    //need to add helmet and hero getters and a player method
    public void setPoints(int points){
        this.points = points;
        highscore =Math.max(points , highscore);
    }
    public int getPoints(){
        return this.points;
    }
    public void setCoins(int coins){
        this.coins = coins;
    }
    public int getCoins(){
        return this.coins;

    }
    public void setName(String name){
        this.name = name;
    }
    public String  getName(){
        return this.name;
    }


}
