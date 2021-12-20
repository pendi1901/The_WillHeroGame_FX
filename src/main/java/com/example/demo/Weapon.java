package com.example.demo;

public abstract class Weapon extends GameObject{
    private int powerLevel;
    private int distanceTravel;
    private boolean isSword;
    Weapon(){
        powerLevel = 0;
        distanceTravel = 0;
    }
    public int getPowerLevel() {
        return powerLevel;
    }

    public int getDistanceTravel() {
        return distanceTravel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setDistanceTravel(int distanceTravel) {
        this.distanceTravel = distanceTravel;
    }

    public boolean getIsSword() {
        return isSword;
    }

    public void setIsSword(boolean sword) {
        isSword = sword;
    }
}
