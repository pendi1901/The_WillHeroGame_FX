package com.example.demo;

public class Platform extends GameObject{
    private Obstacle myObstacle;
    private Orc myOrc;
    private Chest myChest;
    private int whatObj;

    Platform(){
//        myOrc = Math.random()<0.5? (
//                Math.random()<0.5? new RedOrc() : new GreenOrc()
//        ): null;
//        if(myOrc==null){
//            myObstacle = Math.random()<0.6? new TNT() : null;
//            if(myObstacle==null){
//                myChest = Math.random()<0.6? (Math.random()<0.5? new WeaponChest(): new CoinChest()): null;
//                if(myChest==null){
//                    isOrc = 0;
//                }
//                else{
//                    isOrc = 3;
//                }
//            }
//            else{
//                myChest = null;
//                isOrc = 2;
//            }
//        }
//        else{
//            myChest = null;
//            myObstacle = null;
//            isOrc = 1;
//        }
    }
    public Obstacle getMyObstacle() {
        return myObstacle;
    }
    public Orc getMyOrc() {
        return myOrc;
    }
    public Chest getMyChest() {
        return myChest;
    }
    public int getWhatObj() {
        return whatObj;
    }

    public void setWhatObj(int whatObj) {
        this.whatObj = whatObj;
    }
    @Override
    public void display() {

    }

    @Override
    public void hide() {

    }
}
