package com.example.demo;

import java.io.*;

public class SaveGame {

    public static void serialize(){
        int idx = 1;
        File f1 = new File("src/main/resources/saves/game1.txt");
        File f2 = new File("src/main/resources/saves/game2.txt");
        File f3 = new File("src/main/resources/saves/game3.txt");

        if(f1.exists()){
            if(f2.exists()){
                if(f3.exists()){
                    idx = 1;
                }
                else{
                    idx = 3;
                }
            }
            else{
                idx = 2;
            }
        }

        try{
            FileOutputStream file = new FileOutputStream("src/main/resources/saves/game"+idx+".txt");
            ObjectOutputStream out= new ObjectOutputStream(file);
            out.writeObject(GameMain.getInstance());
            out.close();
            file.close();
//            System.out.println("ok serialize");
        }
        catch (FileNotFoundException e) {
//            System.out.println("File Not Found Exception is caught");
        }
        catch (IOException e) {
//            System.out.println("IO Exception is caught");
        }
    }

    public static GameMain deserialize(int idx, boolean del){
        try{
            File f = new File("src/main/resources/saves/game"+idx+".txt");
            if(f.exists()==false){
                throw new NoSaveFoundException("No saved game exists");
            }
            FileInputStream file = new FileInputStream("src/main/resources/saves/game"+idx+".txt");
            ObjectInputStream in = new ObjectInputStream(file);
            GameMain temp = (GameMain) in.readObject();
            in.close();
            file.close();
            if(del) {
                f.delete();
            }
            return temp;
        }
        catch (NoSaveFoundException e) {
//            System.out.println("No Save Found Exception is caught!");
        }
        catch (FileNotFoundException e) {
//            System.out.println("File Not Found Exception is caught!");
        }
        catch (IOException e) {
//            System.out.println("IO Exception is caught!");
        }
        catch (ClassNotFoundException e) {
//            System.out.println("Class Not Found Exception is caught!");
        }
        catch (ClassCastException e){
//            System.out.println("Class Cast Exception is caught!");
        }
//        System.out.println("not ok deserialize");
        return null;
    }
}
