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
        weaponCnt = 0; // 0:none ; 1:exactly one weapon; 2: both weapon
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

    @Override
    public void display() {

    }

    @Override
    public void hide() {

    }
}
