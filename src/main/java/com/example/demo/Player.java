package com.example.demo;

public class Player extends GameObject{
    private Hero myHero;
    private int pointsScored;
    private int coinsCollected;
    private String myName;

    Player(String name){
        this.myHero = new Hero();
        this.pointsScored = 0;
        this.coinsCollected = 0;
        this.myName = name;
    }

    public Hero getHero() {
        return myHero;
    }
    public int getPoints(){
        return this.pointsScored;
    }
    public int getCoins(){
        return this.coinsCollected;
    }
    public String getName(){
        return this.myName;
    }
    public void setPoints(int points){
        this.pointsScored = points;
    }
    public void setCoins(int coinsCollected) {
        this.coinsCollected = coinsCollected;
    }
    public void setName(String name){
        this.myName = name;
    }

    @Override
    public void display() {

    }
    @Override
    public void hide() {

    }
}
