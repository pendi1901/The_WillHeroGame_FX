package com.example.demo;

import java.io.*;

public class SaveGame {
    //Mid Game Saver
    static class Main2 implements Serializable {
        public String name1;
        public float score;
        public int coins;
        public int weaponno;
        public int currweapon;
        public int donetill1;

        public Main2(String name2 , float score1 , int coins1,int weaponno1,int currweapon , int donetill2){
            this.name1 = name2;
            this.coins = coins1;
            this.score = score1;
            this.weaponno = weaponno1;
            this.currweapon = currweapon;
            this.donetill1 = donetill2;
        }

        public void setName1(String name){
            this.name1 = name;
        }
        public String getName1(){
            return name1;
        }
        public void setCoins(int coins){
            this.coins = coins;
        }
        public int getCoins() {
            return coins;
        }
        public void setScore(float score){
            this.score= score;
        }
        public float getScore(){
            return score;
        }
        public void setWeaponno(int weaponno){
            this.weaponno = weaponno;
        }
        public int getWeaponno(){
            return weaponno;
        }
        public void setDonetill1(int donetill2){
            this.donetill1=donetill2;
        }
        public int getDonetill1(){
            return donetill1;
        }
        public void setCurrweapon(int currweapon1){
            this.currweapon = currweapon1;
        }
        public int  getCurrweapon(){
            return currweapon;
        }

    }
    //Serializing Mid Game
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
    //Deserializing Mid Game
    public static void deserializing(){
        Main2 object1 = null;
        try{
            FileInputStream file = new FileInputStream("demo2.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (Main2) in.readObject();
            in.close();
            file.close();
            System.out.println("The object has been deserialized");
            System.out.println("name = "  + object1.name1);
            System.out.println("score = "  + object1.score);
            System.out.println("coins = "  + object1.coins);
            System.out.println("weapon number =  " + object1.weaponno);
            System.out.println("current weaponindex = " + object1.currweapon);
            System.out.println("done till = " +object1.donetill1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
        }
    }

    //End of the Game Saver
    public static class Main implements Serializable{
        private float points;
        private String name;
        public Main(float points1 , String name1){
            this.points = points1;
            this.name = name1;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public float getPoints() {
            return points;
        }
        public void setPoints(float points) {
            this.points = points;
        }
    }
    //For Serializing the End of the Game
    public static void serializing1(Object obj){
        try{
            FileOutputStream file = new FileOutputStream("demo1.txt");
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
    //Deserializing at the End of the Game
    public static void deserializing1(){
        Main object2 = null;
        try{
            FileInputStream file = new FileInputStream("demo1.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            object2 = (Main) in.readObject();
            in.close();
            file.close();
            System.out.println("The object has been deserialized");
            System.out.println("name = "  + object2.name);
            System.out.println("score = "  + object2.points);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
        }
    }
}
