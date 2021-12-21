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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {
    private GameMain myGame = GameMain.getInstance();
    private ArrayList<ImageView> myImages = new ArrayList<>();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView heroHome;
    @FXML
    ImageView greenOrcHome;
    @FXML
    ImageView redOrcHome;
    @FXML
    ImageView platform1;
    @FXML
    ImageView platform2;
    @FXML
    ImageView platform3;
    @FXML
    ImageView platform4;
    @FXML
    Button pauseBtnGamePlay;
//    @FXML
//    ImageView throwKnivesGamePlay;
    @FXML
    Button closeBtnPauseGame;
    @FXML
    Button playBtnPauseGame;
    @FXML
    Button reviveBtnGameOver;

    private AnimationTimer timer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
////        Hero
//        {
//            TranslateTransition translateHero = new TranslateTransition();
//            translateHero.setNode(heroHome);
//            translateHero.setDuration(Duration.millis(800));
//            translateHero.setCycleCount(TranslateTransition.INDEFINITE);
//            translateHero.setByY(-50);
//            translateHero.setAutoReverse(true);
//            translateHero.play();
//        }
////        Green orc
//        {
//            TranslateTransition translateGOrc = new TranslateTransition();
//            translateGOrc.setNode(greenOrcHome);
//            translateGOrc.setDuration(Duration.millis(800));
//            translateGOrc.setDelay(Duration.millis(200));
//            translateGOrc.setCycleCount(TranslateTransition.INDEFINITE);
//            translateGOrc.setByY(-50);
//            translateGOrc.setAutoReverse(true);
//            translateGOrc.play();
//        }
////        Red orc
//        {
//            TranslateTransition translateROrc = new TranslateTransition();
//            translateROrc.setNode(redOrcHome);
//            translateROrc.setDuration(Duration.millis(800));
//            translateROrc.setCycleCount(TranslateTransition.INDEFINITE);
//            translateROrc.setDelay(Duration.millis(400));
//            translateROrc.setByY(-50);
//            translateROrc.setAutoReverse(true);
//            translateROrc.play();
//        }
////        Throw Knives Game Play
//        {
//            TranslateTransition translateKnivesGamePlay = new TranslateTransition();
//            translateKnivesGamePlay.setNode(throwKnivesGamePlay);
//            translateKnivesGamePlay.setDuration(Duration.millis(1600));
//            translateKnivesGamePlay.setCycleCount(TranslateTransition.INDEFINITE);
//            translateKnivesGamePlay.setByX(150);
//            translateKnivesGamePlay.play();
//        }
//        Pause Btn Game Play
//        {
//            ScaleTransition scalePauseBtnGamePlay = new ScaleTransition();
//            scalePauseBtnGamePlay.setNode(pauseBtnGamePlay);
//            scalePauseBtnGamePlay.setDuration(Duration.millis(500));
//            scalePauseBtnGamePlay.setCycleCount(ScaleTransition.INDEFINITE);
//            scalePauseBtnGamePlay.setByX(0.15);
//            scalePauseBtnGamePlay.setByY(0.15);
//            scalePauseBtnGamePlay.setInterpolator(Interpolator.LINEAR);
//            scalePauseBtnGamePlay.setAutoReverse(true);
//            scalePauseBtnGamePlay.play();
//        }
//        Play Btn Home
        {
            ScaleTransition scalePlayBtnPauseGame = new ScaleTransition();
            scalePlayBtnPauseGame.setNode(playBtnPauseGame);
            scalePlayBtnPauseGame.setDuration(Duration.millis(500));
            scalePlayBtnPauseGame.setCycleCount(ScaleTransition.INDEFINITE);
            scalePlayBtnPauseGame.setByX(0.12);
            scalePlayBtnPauseGame.setByY(0.12);
            scalePlayBtnPauseGame.setInterpolator(Interpolator.LINEAR);
            scalePlayBtnPauseGame.setAutoReverse(true);
            scalePlayBtnPauseGame.play();
        }
//        Close Btn Load game
        {
            ScaleTransition scaleCloseBtnPauseGame = new ScaleTransition();
            scaleCloseBtnPauseGame.setNode(closeBtnPauseGame);
            scaleCloseBtnPauseGame.setDuration(Duration.millis(500));
            scaleCloseBtnPauseGame.setCycleCount(ScaleTransition.INDEFINITE);
            scaleCloseBtnPauseGame.setByX(0.15);
            scaleCloseBtnPauseGame.setByY(0.15);
            scaleCloseBtnPauseGame.setInterpolator(Interpolator.LINEAR);
            scaleCloseBtnPauseGame.setAutoReverse(true);
            scaleCloseBtnPauseGame.play();
        }
//        Revive Btn Game Over
        {
            RotateTransition rotateReviveBtnGameOver = new RotateTransition();
            rotateReviveBtnGameOver.setNode(reviveBtnGameOver);
            rotateReviveBtnGameOver.setDuration(Duration.millis(2000));
            rotateReviveBtnGameOver.setCycleCount(ScaleTransition.INDEFINITE);
            rotateReviveBtnGameOver.setToAngle(-359);
            rotateReviveBtnGameOver.setInterpolator(Interpolator.LINEAR);
            rotateReviveBtnGameOver.play();
        }

//        Set platform images
        {
            platform1.setLayoutX(myGame.getCurrPlatforms().get(0).getInf().getX());
            platform1.setLayoutY(myGame.getCurrPlatforms().get(0).getInf().getY());
            myImages.add(platform1);
            platform2.setLayoutX(myGame.getCurrPlatforms().get(1).getInf().getX());
            platform2.setLayoutY(myGame.getCurrPlatforms().get(1).getInf().getY());
            myImages.add(platform2);
            platform3.setLayoutX(myGame.getCurrPlatforms().get(2).getInf().getX());
            platform3.setLayoutY(myGame.getCurrPlatforms().get(2).getInf().getY());
            myImages.add(platform3);
            platform4.setLayoutX(myGame.getCurrPlatforms().get(3).getInf().getX());
            platform4.setLayoutY(myGame.getCurrPlatforms().get(3).getInf().getY());
            myImages.add(platform4);
        }

        pauseBtnGamePlay.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode()==KeyCode.RIGHT){
                move();
            }
        });

//        timer = new AnimationTimer() {
//            @Override
//            public void stop() {
//                super.stop();
//            }
//            @Override
//            public void handle(long l) {
//                System.out.print("ok");
//            }
//        };
    }

    //    ---------------------------------------- Game Play ------------------------------------------
    public void move(){
        int changeXBy = 40;
        for (int i = 0; i < 4; i++) {
            Inf tempInf = myGame.getCurrPlatforms().get(i).getInf();
            if (tempInf.getX() + tempInf.getLen() < 0) {
//              System.out.println(myImages.get(i).getLayoutX()+" oops");
                myGame.getCurrPlatforms().get(i).getInf().setX(myGame.getCurrPlatforms().get(i-1<0?3:i-1).getInf().getX() + (i-1<0?280-changeXBy:280));
            } else {
//              System.out.println(myImages.get(i).getLayoutX()+" ok");
                myGame.getCurrPlatforms().get(i).getInf().changeX(-changeXBy);
            }
            myImages.get(i).setLayoutX(myGame.getCurrPlatforms().get(i).getInf().getX());
        }
    }
    public void clicked_pause_btn_game_play(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_pause.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) pauseBtnGamePlay.getScene().getWindow();
        stage.setTitle("Will Hero - Game Paused");
        stage.setScene(scene);
    }

    //    ---------------------------------------- Pause Game ------------------------------------------
    public void clicked_close_btn_pause_game(ActionEvent e) throws IOException {
        Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
        myAlert.setTitle("Confirmation Prompt");
        myAlert.setHeaderText("Are you sure, you want to exit this current game?");
        myAlert.setContentText("Your data for this game will be lost!");
        if(myAlert.showAndWait().get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 380);
            Stage stage = (Stage) closeBtnPauseGame.getScene().getWindow();
            stage.setTitle("Will Hero - Home");
            stage.setScene(scene);
        }
    }

    public void clicked_play_btn_pause_game(ActionEvent e) throws IOException {
        timer.start();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) playBtnPauseGame.getScene().getWindow();
        stage.setTitle("Will Hero - Playing Game");
        stage.setScene(scene);
    }

    //  To be changed
    @FXML
    Button saveBtnPauseGame;
    public void clicked_save_btn_pause_game(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_over.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) saveBtnPauseGame.getScene().getWindow();
        stage.setTitle("Will Hero - Game Over");
        stage.setScene(scene);
    }

    //    ---------------------------------------- Game Over ------------------------------------------
//  To be changed
    public void clicked_revive_btn_game_over(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_result.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) reviveBtnGameOver.getScene().getWindow();
        stage.setTitle("Will Hero - Game Result");
        stage.setScene(scene);
    }

}