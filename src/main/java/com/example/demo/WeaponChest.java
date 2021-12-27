package com.example.demo;

public class WeaponChest extends Chest {
    private Weapon myWeapon;
    WeaponChest(){
        super.setIsWeaponChest(true);
        myWeapon = Math.random()<0.5 ? new ThrowingKnife(): new Sword();
    }
    public Weapon getWeapon(){
        return this.myWeapon;
    }
    @Override
    public void display() {
        System.out.println(this.getIsWeaponChest());
    }

    @Override
    public void hide() {
        this.display();
        System.out.println(this.getWeapon());
    }
}
