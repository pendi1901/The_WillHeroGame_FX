package com.example.demo;

public abstract class Obstacle extends GameObject {
    private int distAffected;

    public int getDistAffected() {
        return distAffected;
    }

    public void setDistAffected(int distAffected) {
        this.distAffected = distAffected;
    }
}
