package com.example.demo;

public class ThrowingKnife extends Weapon{
    ThrowingKnife(){
        super.setIsSword(false);
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
