package com.example.demo;

import java.io.*;

public class SaveLeaderBoard {

    public static void serialize(Object obj){
        FileOutputStream file = null;
        ObjectOutputStream out = null;
        try{
            file = new FileOutputStream("src/main/resources/saves/leaderBoard.txt");
            out = new ObjectOutputStream(file);
            out.writeObject(obj);
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found Exception is caught!");
        } catch (IOException e) {
//            System.out.println("IO Exception is caught!");
        }
    }

    public static GameResultController.LinkedListSorter deserialize(){
        GameResultController.LinkedListSorter object1 = null;
        try{
            FileInputStream file = new FileInputStream("src/main/resources/saves/leaderBoard.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (GameResultController.LinkedListSorter) in.readObject();
            in.close();
            file.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found Exception is caught!");
        } catch (IOException e) {
//            System.out.println("IO Exception is caught!");
        } catch (ClassNotFoundException e) {
//            System.out.println("Class Not Found Exception is caught!");
        }

        return object1;
    }
}
