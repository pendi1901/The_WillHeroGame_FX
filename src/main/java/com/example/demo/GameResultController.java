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
import java.io.IOException;
import java.net.URL;
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