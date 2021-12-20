package com.example.demo;

public class Hero extends GameObject{
    private Helmet myHelmet;
    Hero(){
        myHelmet = new Helmet();
    }
    public Helmet getMyHelmet() {
        return myHelmet;
    }
    @Override
    public void display() {

    }
    @Override
    public void hide() {

    }
}
