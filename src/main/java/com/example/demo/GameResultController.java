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

    // Everything related to linked lists in this program for the sorting things
    static class LinkedListSorter implements Serializable{

        static class Node implements Serializable {
            int data;
            String string;
            Node next;

            public Node(int data, String string) {
                this.data = data;
                this.string = string;
                this.next = null;
            }
        }
        Node head = null;
        Node tail = null;

        private LinkedListSorter(){}
        private static LinkedListSorter list = null;

        public static LinkedListSorter getInstance(){
            list = SaveLeaderBoard.deserialize();
            return list = (list==null?new LinkedListSorter():list);
        }

        public static void serialize(){
            SaveLeaderBoard.serialize(list);
        }

        public static void addNode(int data, String string) {
            Node newNode = new Node(data, string);
            if (list.head == null) {
                list.head = newNode;
            } else {
                list.tail.next = newNode;
            }
            list.tail = newNode;
        }

        public static void sortList() {
            Node current = list.head;
            Node index = null;
            int temp;
            String temp2;
            if (list.head == null) {
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

        public int getcount(){
            Node temp = list.head;
            int count=0;
            while(temp!= null){
                count++;
                temp =temp.next;
            }
            return count;
        }
        public int getNthno(int indno){
            Node current = list.head;
            int count = 0 ;
            while(current != null){
                if(count == indno){
                    return current.data;
                }
                count++;
                current = current.next;
            }
            return 0;
        }
        public String getNthname(int index){
            Node current  = list.head;
            int count =0;
            while(current !=null){
                if(count == index){
                    return current.string;
                }
                count++;
                current = current.next;
            }
            assert (false);
            return null;
        }
        public void display() {
            Node current = list.head;
            if (list.head == null) {
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
//        Add to Leaderboard
        {
            LinkedListSorter.getInstance();
            LinkedListSorter.addNode((int)(myGame.getCurrPlayer().getPoints()), myGame.getCurrPlayer().getName());
            LinkedListSorter.sortList();
            LinkedListSorter.serialize();
        }

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