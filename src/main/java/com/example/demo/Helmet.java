package com.example.demo;

import java.util.ArrayList;

public class Helmet extends GameObject{
    private ArrayList<Weapon> allWeapons;
    private int selectedIdx;
    private int weaponCnt;

    Helmet(){
        allWeapons = new ArrayList<>();
        allWeapons.add(new ThrowingKnife());
        allWeapons.add(new Sword());
        selectedIdx = -1;
        weaponCnt = 0; // 0:none ; 1:exactly one weapon; >=2: both weapon
    }

    public int getSelectedIdx() {
        return selectedIdx;
    }

    public int getWeaponCnt() {
        return weaponCnt;
    }

    public ArrayList<Weapon> getAllWeapons() {
        return allWeapons;
    }

    public void setSelectedIdx() {
        this.selectedIdx = (this.selectedIdx==-1 ? (Math.random()<0.5? 0:1) : 1-this.selectedIdx);
    }

    public void setWeaponCnt() {
        this.weaponCnt += 1;
    }

    public void resetWeaponCnt() {
        this.weaponCnt = 0;
    }
    public void resetSelectedIdx() {
        this.selectedIdx = -1;
    }

    @Override
    public void display() {

    }

    @Override
    public void hide() {

    }
}
