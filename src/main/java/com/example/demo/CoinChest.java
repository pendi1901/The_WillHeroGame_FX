package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

public class CoinChest extends Chest implements Cloneable{
    private int coins;

    CoinChest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); list.add(10); list.add(20);
        Random rand = new Random();
        this.coins  = list.get(rand.nextInt(list.size()));
        super.setIsWeaponChest(false);
    }

    public int getCoins(){
        return this.coins;
    }

    @Override
    public CoinChest clone(){
        try {
            CoinChest copy = (CoinChest) super.clone();
            return copy;
        }
        catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println(this.getCoins());
    }

    @Override
    public void hide() {
        this.display();
        this.clone();
    }
}
