package com.example.demo;

public class TNT extends Obstacle{

    public void blast(){

    }
    @Override
    public void display() {
        System.out.println(this.getDistAffected());
    }

    @Override
    public void hide() {
        this.display();
        this.setDistAffected(0);
    }
}
