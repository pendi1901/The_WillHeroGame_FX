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
        System.out.println(this.getMyHelmet().getAllWeapons());
    }
    @Override
    public void hide() {
        this.display();
        this.getMyHelmet().resetWeaponCnt();
    }
}
