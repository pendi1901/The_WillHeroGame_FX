package com.example.demo;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GameResultController implements Initializable {
    private GameMain myGame = GameMain.getInstance();
    LinkedListSorter list1 = new LinkedListSorter();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView heroHome;
    @FXML
    ImageView greenOrcHome;
    @FXML
    Button homeBtnGameResult;
    @FXML
    Label bestScore;
    @FXML
    Label pointsScoredGamePlay;
    //Midgame Saver
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
// Everything related to linked lists in this program for the sorting thingi
    static class LinkedListSorter {
        static class Node {
            float data;
            String string;
            Node next;

            public Node(float data, String string) {
                this.data = data;
                this.string = string;
                this.next = null;
            }
        }

        public Node head = null;
        public Node tail = null;
        private LinkedListSorter(){

        }
        private static LinkedListSorter list= null;
        public static LinkedListSorter getInstance(){
            if(list==null){
                list = new LinkedListSorter();
            }
            return list;
        }
        public void addNode(float data, String string) {
            Node newNode = new Node(data, string);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void sortList() {
            Node current = head;
            Node index = null;
            float temp;
            String temp2;
            if (head == null) {
                return;
            } else {
                while (current != null) {
                    index = current.next;

                    while (index != null) {
                        if (current.data > index.data) {
                            temp = current.data;
                            temp2 = current.string;
                            current.data = index.data;
                            current.string = index.string;
                            index.data = temp;
                            index.string = temp2;
                        }
                        index = index.next;
                    }
                    current = current.next;
                }
            }
        }

        public void display() {
            Node current = head;
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            while (current != null) {
                System.out.println(current.data + " " + current.string + " ");
                current = current.next;
            }
            System.out.println();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Hero
        {
            TranslateTransition translateHero = new TranslateTransition();
            translateHero.setNode(heroHome);
            translateHero.setDuration(Duration.millis(800));
            translateHero.setCycleCount(TranslateTransition.INDEFINITE);
            translateHero.setByY(-50);
            translateHero.setAutoReverse(true);
            translateHero.play();
        }
//        Green orc
        {
            TranslateTransition translateGOrc = new TranslateTransition();
            translateGOrc.setNode(greenOrcHome);
            translateGOrc.setDuration(Duration.millis(800));
            translateGOrc.setDelay(Duration.millis(200));
            translateGOrc.setCycleCount(TranslateTransition.INDEFINITE);
            translateGOrc.setByY(-50);
            translateGOrc.setAutoReverse(true);
            translateGOrc.play();
        }
//        Home Btn Game Result
        {
            ScaleTransition scaleHomeBtnGameResult = new ScaleTransition();
            scaleHomeBtnGameResult.setNode(homeBtnGameResult);
            scaleHomeBtnGameResult.setDuration(Duration.millis(500));
            scaleHomeBtnGameResult.setCycleCount(ScaleTransition.INDEFINITE);
            scaleHomeBtnGameResult.setByX(0.12);
            scaleHomeBtnGameResult.setByY(0.12);
            scaleHomeBtnGameResult.setInterpolator(Interpolator.LINEAR);
            scaleHomeBtnGameResult.setAutoReverse(true);
            scaleHomeBtnGameResult.play();
        }
        {

            Main2 obj = new Main2(null , 0 ,0,0,0,0 );
            String name = ((myGame.getCurrPlayer().getName()));
            int a  = (myGame.getCurrPlayer().getCoins());
            float b = (myGame.getCurrPlayer().getPoints());
            int c =  myGame.getCurrPlayer().getHero().getMyHelmet().getWeaponCnt();
            int d = myGame.getCurrPlayer().getHero().getMyHelmet().getSelectedIdx();
            int e = myGame.getDoneTill();
            obj.setCoins(a);
            obj.setScore(b);
            obj.setName1(name);
            obj.setWeaponno(c);
            obj.setCurrweapon(d);
            obj.setDonetill1(e);
            serializing(obj);
            deserializing();

            LinkedListSorter list = LinkedListSorter.getInstance();


            Main obj1 = new Main(0 , null);
            String name1 = ((myGame.getCurrPlayer().getName()));
            float b1 = (myGame.getCurrPlayer().getPoints());
            obj1.setName(name1);
            obj1.setPoints(b1);
            serializing1(obj1);
            deserializing1();
            list.addNode(b1 , name);
            System.out.println("original list");
            list.display();
            list.sortList();
            System.out.println("sorted list");
            list.display();

        }

        //Sorting algorithm with linked lists

        if(pointsScoredGamePlay!=null){
            pointsScoredGamePlay.setText(Integer.toString((int)myGame.getCurrPlayer().getPoints()));
        }
        bestScore.setText(Integer.toString(130));
    }

    //    ---------------------------------------- Game Result ------------------------------------------
    public void clicked_home_btn_game_result(ActionEvent e) throws IOException {
        PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
        btnClick.play();
        myGame.getMyMusic().stop();
        myGame.setMyMusic(new PlayMusic("src/main/resources/assets/Audio/gamePlay.mp3"));
        myGame.getMyMusic().play();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) homeBtnGameResult.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

}