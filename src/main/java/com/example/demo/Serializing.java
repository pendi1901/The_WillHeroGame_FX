package com.example.demo;

import java.io.*;
// Rudimentary file delete once you're done with it!!!!!!!
public class Serializing {
    static class Main2 implements Serializable{
        public String name1;
        public String score;
        public String coins;

        public Main2(String name2 , String score1 , String coins1){
            this.name1 = name2;
            this.coins = coins1;
            this.score = score1;
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

    }
    //Serializing
    public static void serializing(Object obj){
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
    //Deserializing
    public static void deserializing(){
        Main2 object1 = null;
        try{
            FileInputStream file = new FileInputStream("demo1.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (Main2) in.readObject();
            in.close();
            file.close();
            System.out.println("The object has been deserialized");
            System.out.println("name = "  + object1.name1);
            System.out.println("name = "  + object1.score);
            System.out.println("name = "  + object1.coins);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
        }
    }
    public static void main(String [] args){
        Main2 obj = new Main2(null , null ,null );
        GameMain myGame = GameMain.getInstance();
        String name = ((myGame.getCurrPlayer().getName()));
        String a  = (Integer.toString((int)myGame.getCurrPlayer().getCoins()));
        String b = (Integer.toString((int)myGame.getCurrPlayer().getPoints()));
        obj.setCoins(a);
        obj.setScore(b);
        obj.setName1(name);

        serializing(obj);
        deserializing();


    }

}
