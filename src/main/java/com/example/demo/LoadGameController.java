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
    Label LabelSno;
    @FXML
    Label LabelName;
    @FXML
    Label LabelScore;

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

        //Load Saved Game Button
        {
            ScaleTransition scaleLoadSavedGame = new ScaleTransition();
            scaleLoadSavedGame.setNode(LoadSavedGame);
            scaleLoadSavedGame.setDuration(Duration.millis(500));
            scaleLoadSavedGame.setCycleCount(ScaleTransition.INDEFINITE);
            scaleLoadSavedGame.setByX(0.15);
            scaleLoadSavedGame.setByY(0.15);
            scaleLoadSavedGame.setInterpolator(Interpolator.LINEAR);
            scaleLoadSavedGame.setAutoReverse(true);
            scaleLoadSavedGame.play();
        }
        {
            LabelSno.setText("1");
            LabelName.setText(myGame.getCurrPlayer().getName());
            LabelScore.setText(Integer.toString(myGame.getCurrPlayer().getCoins()));
        }
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

    @FXML
    Button LoadSavedGame;

    public void clicked_load_savegame_btn(ActionEvent e) throws IOException{
        PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
        btnClick.play();
        myGame.loadGame();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 680 , 380);
        Stage stage = (Stage) LoadSavedGame.getScene().getWindow();
        stage.setTitle("Will Hero - Playing Game");
        stage.setScene(scene);
    }

}