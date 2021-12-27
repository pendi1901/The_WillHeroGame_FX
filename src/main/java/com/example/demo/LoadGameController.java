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
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {
    private GameMain myGame = GameMain.getInstance();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    Button closeBtnLoadGame;

    @FXML
    Button load_game_btn_1;
    @FXML
    Button load_game_btn_2;
    @FXML
    Button load_game_btn_3;

    @FXML
    Label sn1;
    @FXML
    Label sn2;
    @FXML
    Label sn3;

    @FXML
    Label n1;
    @FXML
    Label n2;
    @FXML
    Label n3;

    @FXML
    Label sc1;
    @FXML
    Label sc2;
    @FXML
    Label sc3;

    @FXML
    Label noDisplayTxt;

    private int config = -1;

    public void label_1(GameMain g) {
        load_game_btn_1.setVisible(true);
        sn1.setVisible(true);
        n1.setVisible(true);
        sc1.setVisible(true);
        sn1.setText("1");
        n1.setText(g.getCurrPlayer().getName());
        sc1.setText(Integer.toString((int) g.getCurrPlayer().getPoints()));
    }

    public void label_2(GameMain g) {
        load_game_btn_2.setVisible(true);
        sn2.setVisible(true);
        n2.setVisible(true);
        sc2.setVisible(true);
        sn2.setText("2");
        n2.setText(g.getCurrPlayer().getName());
        sc2.setText(Integer.toString((int) g.getCurrPlayer().getPoints()));
    }

    public void label_3(GameMain g) {
        load_game_btn_3.setVisible(true);
        sn3.setVisible(true);
        n3.setVisible(true);
        sc3.setVisible(true);
        sn3.setText("3");
        n3.setText(g.getCurrPlayer().getName());
        sc3.setText(Integer.toString((int) g.getCurrPlayer().getPoints()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Close Btn Load game
        {
            ScaleTransition scaleCloseBtnLoadGame = new ScaleTransition();
            scaleCloseBtnLoadGame.setNode(closeBtnLoadGame);
            scaleCloseBtnLoadGame.setDuration(Duration.millis(500));
            scaleCloseBtnLoadGame.setCycleCount(ScaleTransition.INDEFINITE);
            scaleCloseBtnLoadGame.setByX(0.15);
            scaleCloseBtnLoadGame.setByY(0.15);
            scaleCloseBtnLoadGame.setInterpolator(Interpolator.LINEAR);
            scaleCloseBtnLoadGame.setAutoReverse(true);
            scaleCloseBtnLoadGame.play();
        }
//        Hide elements relate to load
        {
            config = -1;
            load_game_btn_1.setVisible(false);
            load_game_btn_2.setVisible(false);
            load_game_btn_3.setVisible(false);
            sn1.setVisible(false);
            sn2.setVisible(false);
            sn3.setVisible(false);
            n1.setVisible(false);
            n2.setVisible(false);
            n3.setVisible(false);
            sc1.setVisible(false);
            sc2.setVisible(false);
            sc3.setVisible(false);
            noDisplayTxt.setVisible(false);
        }
//        Deserialize and set config
        {
            GameMain g1 = SaveGame.deserialize(1, false);
            GameMain g2 = SaveGame.deserialize(2, false);
            GameMain g3 = SaveGame.deserialize(3, false);
            if (g1 == null) {
                if (g2 == null) {
                    if (g3 == null) {
                        config = 0;
                        noDisplayTxt.setVisible(true);
                    } else {
                        config = 1;
                        label_1(g3);
                    }
                }
                else {
                    label_1(g2);
                    if (g3 == null) {
                        config = 2;
                    } else {
                        config = 3;
                        label_2(g3);
                    }
                }
            }
            else {
                label_1(g1);
                if (g2 == null) {
                    if (g3 == null) {
                        config = 4;
                    } else {
                        config = 5;
                        label_2(g3);
                    }
                }
                else {
                    label_2(g2);
                    if (g3 == null) {
                        config = 6;
                    } else {
                        config = 7;
                        label_3(g3);
                    }
                }
            }

        }
    }

    public GameMain get_game(int config, int idx){
        GameMain temp = null;
        if(idx==1){
            if(config>=4){
                temp = SaveGame.deserialize(1, true);
            }
            else if(config==2 || config==3){
                temp = SaveGame.deserialize(2, true);
            }
            else if(config==1){
                temp = SaveGame.deserialize(3, true);
            }
        }
        else if(idx==2){
            if(config==6||config==7){
                temp = SaveGame.deserialize(2, true);
            }
            else if(config==3||config==5){
                temp = SaveGame.deserialize(3, true);
            }
        }
        else if(idx==3 && config==7){
            temp = SaveGame.deserialize(3, true);
        }
        return temp;
    }

    //    ---------------------------------------- Load Game ------------------------------------------
    public void clicked_close_btn_load_game(ActionEvent e) throws IOException {
        PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
        btnClick.play();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

    public void clicked_load_game_btn_1(ActionEvent e) throws IOException {
        if(config>=1) {
            PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
            btnClick.play();
            myGame.loadGame(get_game(config, 1));
            if(myGame.getMyMusic()!=null) {
                myGame.getMyMusic().stop();
                myGame.setMyMusic(new PlayMusic("src/main/resources/assets/Audio/game.mp3"));
                myGame.getMyMusic().play();
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 380);
            Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
            stage.setTitle("Will Hero - Playing Game");
            stage.setScene(scene);
        }
    }

    public void clicked_load_game_btn_2(ActionEvent e) throws IOException {
        if(config>=3) {
            PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
            btnClick.play();
            myGame.loadGame(get_game(config, 2));
            if(myGame.getMyMusic()!=null) {
                myGame.getMyMusic().stop();
                myGame.setMyMusic(new PlayMusic("src/main/resources/assets/Audio/game.mp3"));
                myGame.getMyMusic().play();
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 380);
            Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
            stage.setTitle("Will Hero - Playing Game");
            stage.setScene(scene);
        }
    }

    public void clicked_load_game_btn_3(ActionEvent e) throws IOException {
        if(config==7) {
            PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
            btnClick.play();
            myGame.loadGame(get_game(config, 3));
            if(myGame.getMyMusic()!=null) {
                myGame.getMyMusic().stop();
                myGame.setMyMusic(new PlayMusic("src/main/resources/assets/Audio/game.mp3"));
                myGame.getMyMusic().play();
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 380);
            Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
            stage.setTitle("Will Hero - Playing Game");
            stage.setScene(scene);
        }
    }

}