package com.example.demo;

public class Sword extends Weapon{
    Sword(){
        super.setIsSword(true);
    }

    @Override
    public void display() {
        System.out.println(this.getPowerLevel());
    }

    @Override
    public void hide() {
        this.display();
        System.out.println(this.getDistanceTravel());
    }
}
