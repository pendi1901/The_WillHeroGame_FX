package com.example.demo;

public class GreenOrc extends Orc{
    GreenOrc(){
        super.setWhichOrc(1);
    }
    @Override
    public void display() {
        this.push();
    }

    @Override
    public void hide() {
        this.display();
        this.clone();
    }
}
