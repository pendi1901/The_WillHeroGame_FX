package com.example.demo;

import java.io.*;
// Rudimentary file delete once you're done with it!!!!!!!
public class SavingInTheMiddle {
    static class Main3 implements Serializable {
        public String name1;
        public String score;
        public String coins;
        public int weaponno;
        public String weaponlevel1;
        public String weaponlevel2;
        public int currweapon;


        public Main3(String name2 , String score1 , String coins1,int weaponno1,String weaponlevel1,String weaponlevel2,int currweapon){
            this.name1 = name2;
            this.coins = coins1;
            this.score = score1;
            this.weaponno = weaponno1;
            this.weaponlevel1 = weaponlevel1;
            this.weaponlevel2 = weaponlevel2;
            this.currweapon = currweapon;
        }
        public void setName1(String name){
            this.name1 = name;
        }
        public String getName1(){
            return name1;
        }
        public void setCoins(String coins){
            this.coins = coins;
        }
        public String getCoins() {
            return coins;
        }
        public void setScore(String score){
            this.score= score;
        }
        public String getScore(){
            return score;
        }
        public void setWeaponno(int weaponno){
            this.weaponno = weaponno;
        }
        public int getWeaponno(){
            return weaponno;
        }
        public void setWeaponlevel1(String weaponlevel1){
            this.weaponlevel1 = weaponlevel1;
        }
        public String getWeaponlevel1(){
            return weaponlevel1;
        }
        public void setWeaponlevel2(String weaponlevel2){
            this.weaponlevel2 = weaponlevel2;
        }
        public String getWeaponlevel2(){
            return weaponlevel2;
        }
        public void setCurrweapon(int currweapon1){
            this.currweapon = currweapon1;
        }
        public int  getCurrweapon(){
            return currweapon;
        }

        //Serializing
        public static void serializing(Object obj){
            try{
                FileOutputStream file = new FileOutputStream("demo2.txt");
                ObjectOutputStream out= new ObjectOutputStream(file);
                out.writeObject(obj);
                out.close();
                file.close();
                System.out.println("Object has been serialised");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IO Exception is caught");
            }
        }
        public static void deserializing(){
            Main3 object1 = null;
            try{
                FileInputStream file = new FileInputStream("demo2.txt");
                ObjectInputStream in = new ObjectInputStream(file);
                object1 = (Main3) in.readObject();
                in.close();
                file.close();
                System.out.println("The object has been deserialized");
                System.out.println("name = "  + object1.name1);
                System.out.println("score = "  + object1.score);
                System.out.println("coins = "  + object1.coins);
                System.out.println("weapon number =  " + object1.weaponno);
                System.out.println("weapon level for Sword = " + object1.weaponlevel1);
                System.out.println("weapon level for Throwing Knives = " + object1.weaponlevel2);
                System.out.println("current weaponindex = " + object1.currweapon);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IO Exception is caught");
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception");
            }
        }

        public static void main(String [] args){
            Main3 obj = new Main3(null,null,null,0,null,null,-1);
            GameMain myGame = GameMain.getInstance();
            String name = ((myGame.getCurrPlayer().getName()));
            String a  = (Integer.toString((int)myGame.getCurrPlayer().getCoins()));
            String b = (Integer.toString((int)myGame.getCurrPlayer().getPoints()));
            int c =  myGame.getCurrPlayer().getHero().getMyHelmet().getWeaponCnt();
            int d = myGame.getCurrPlayer().getHero().getMyHelmet().getSelectedIdx();
            obj.setName1(name);
            obj.setCoins(a);
            obj.setScore(b);
            obj.setWeaponno(c);
            obj.setCurrweapon(d);
            serializing(obj);
            deserializing();



        }
    }
}
