package com.example.demo;

public abstract class Chest extends GameObject {
    private boolean isWeaponChest;

    public void setIsWeaponChest(boolean t){
        this.isWeaponChest = t;
    }
    public boolean getIsWeaponChest(){
        return this.isWeaponChest;
    }
}
