package com.example.demo;

public abstract class Orc extends GameObject{
    private int power;
    private int coins;
    private int whichOrc;   // 0 for Red; 1 for Green; 2 for Boss

    public void push() {

    }
    public int getCoins() {
        return coins;
    }
    public int getPower() {
        return power;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void reducePower(int decrease) {
        this.power -= decrease;
    }
    public int getWhichOrc() {
        return whichOrc;
    }
    public void setWhichOrc(int whichOrc) {
        this.whichOrc = whichOrc;
    }
}
