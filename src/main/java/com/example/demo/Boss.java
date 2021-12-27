package com.example.demo;

public class Boss extends Orc{
    Boss(){
        super.setWhichOrc(2);
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
