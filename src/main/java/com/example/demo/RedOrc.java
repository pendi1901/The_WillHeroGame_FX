package com.example.demo;

public class RedOrc extends Orc{
    RedOrc(){
        super.setWhichOrc(0);
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
