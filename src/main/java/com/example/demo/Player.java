package com.example.demo;

public class Player extends GameObject{
    private Hero myHero;
    private float pointsScored;
    private int coinsCollected;
    private String myName;
    private int prevStart;  // last collision point Y value
    private int jumpHeight; // height jumped by player in Y direction
    private int currX;   // current X position
    private int moveX;  // direction of movement 1:RIGHT and -1: LEFT

    Player(String name){
        this.myHero = new Hero();
        this.pointsScored = 0;
        this.coinsCollected = 0;
        this.myName = name;
        this.prevStart = 140;
        this.jumpHeight = 90;
        this.currX = 60;
        this.moveX = 1;
    }

    public Hero getHero() {
        return myHero;
    }
    public float getPoints(){
        return this.pointsScored;
    }
    public int getCoins(){
        return this.coinsCollected;
    }
    public String getName(){
        return this.myName;
    }
    public int getJumpHeight() {
        return jumpHeight;
    }
    public int getPrevStart() {
        return prevStart;
    }
    public int getCurrX() {
        return currX;
    }
    public int getMoveX(){return moveX;}

    public void setCurrX(int currX) {
        this.currX = currX;
    }
    public void toggleMoveX() {
        this.moveX *= -1;
    }
    public void setMoveX(int moveX){this.moveX = moveX;}
    public void setPrevStart(int prevStart) {
        this.prevStart = prevStart;
    }
    public void setPoints(float points){
        this.pointsScored = points;
    }
    public void setCoins(int coinsCollected) {
        this.coinsCollected = coinsCollected;
    }
    public void setName(String name){
        this.myName = name;
    }
    public void changePoints(double change){this.pointsScored+=change;}

    @Override
    public void display() {

    }
    @Override
    public void hide() {

    }
}
