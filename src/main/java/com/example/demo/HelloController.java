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
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView heroHome;
    @FXML
    ImageView greenOrcHome;
    @FXML
    ImageView redOrcHome;
    @FXML
    Button playBtnHome;
    @FXML
    ImageView crownBtnLeaderBoard;
    @FXML
    Button closeBtnLoadGame;
    @FXML
    Button closeBtnLeaderBoard;
    @FXML
    Button pauseBtnGamePlay;
    @FXML
    ImageView throwKnivesGamePlay;
    @FXML
    Button closeBtnPauseGame;
    @FXML
    Button playBtnPauseGame;
    @FXML
    Button reviveBtnGameOver;
    @FXML
    Button homeBtnGameResult;

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
//        Red orc
        {
            TranslateTransition translateROrc = new TranslateTransition();
            translateROrc.setNode(redOrcHome);
            translateROrc.setDuration(Duration.millis(800));
            translateROrc.setCycleCount(TranslateTransition.INDEFINITE);
            translateROrc.setDelay(Duration.millis(400));
            translateROrc.setByY(-50);
            translateROrc.setAutoReverse(true);
            translateROrc.play();
        }
//        Play Btn Home
        {
            ScaleTransition scalePlayBtnHome = new ScaleTransition();
            scalePlayBtnHome.setNode(playBtnHome);
            scalePlayBtnHome.setDuration(Duration.millis(500));
            scalePlayBtnHome.setCycleCount(ScaleTransition.INDEFINITE);
            scalePlayBtnHome.setByX(0.12);
            scalePlayBtnHome.setByY(0.12);
            scalePlayBtnHome.setInterpolator(Interpolator.LINEAR);
            scalePlayBtnHome.setAutoReverse(true);
            scalePlayBtnHome.play();
        }
//        Crown Img Leaderboard
        {
            ScaleTransition scaleCrownBtnLeaderBoard = new ScaleTransition();
            scaleCrownBtnLeaderBoard.setNode(crownBtnLeaderBoard);
            scaleCrownBtnLeaderBoard.setDuration(Duration.millis(500));
            scaleCrownBtnLeaderBoard.setCycleCount(ScaleTransition.INDEFINITE);
            scaleCrownBtnLeaderBoard.setByX(0.13);
            scaleCrownBtnLeaderBoard.setByY(0.13);
            scaleCrownBtnLeaderBoard.setInterpolator(Interpolator.LINEAR);
            scaleCrownBtnLeaderBoard.setAutoReverse(true);
            scaleCrownBtnLeaderBoard.play();
        }
//        Close Btn Leaderboard
        {
            ScaleTransition scaleCloseBtnLeaderboard = new ScaleTransition();
            scaleCloseBtnLeaderboard.setNode(closeBtnLeaderBoard);
            scaleCloseBtnLeaderboard.setDuration(Duration.millis(500));
            scaleCloseBtnLeaderboard.setCycleCount(ScaleTransition.INDEFINITE);
            scaleCloseBtnLeaderboard.setByX(0.15);
            scaleCloseBtnLeaderboard.setByY(0.15);
            scaleCloseBtnLeaderboard.setInterpolator(Interpolator.LINEAR);
            scaleCloseBtnLeaderboard.setAutoReverse(true);
            scaleCloseBtnLeaderboard.play();
        }
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
//        Pause Btn Game Play
        {
            ScaleTransition scalePauseBtnGamePlay = new ScaleTransition();
            scalePauseBtnGamePlay.setNode(pauseBtnGamePlay);
            scalePauseBtnGamePlay.setDuration(Duration.millis(500));
            scalePauseBtnGamePlay.setCycleCount(ScaleTransition.INDEFINITE);
            scalePauseBtnGamePlay.setByX(0.15);
            scalePauseBtnGamePlay.setByY(0.15);
            scalePauseBtnGamePlay.setInterpolator(Interpolator.LINEAR);
            scalePauseBtnGamePlay.setAutoReverse(true);
            scalePauseBtnGamePlay.play();
        }
//        Throw Knives Game Play
        {
            TranslateTransition translateKnivesGamePlay = new TranslateTransition();
            translateKnivesGamePlay.setNode(throwKnivesGamePlay);
            translateKnivesGamePlay.setDuration(Duration.millis(1600));
            translateKnivesGamePlay.setCycleCount(TranslateTransition.INDEFINITE);
            translateKnivesGamePlay.setByX(150);
            translateKnivesGamePlay.play();
        }
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
    }

//    ---------------------------------------- Home Screen ------------------------------------------
    public void clicked_play_btn_home(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) playBtnHome.getScene().getWindow();
        stage.setTitle("Will Hero - Playing Game");
        stage.setScene(scene);
    }

    @FXML
    Button closeBtnHome;
    public void clicked_close_btn_home(ActionEvent e) throws IOException {
        Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
        myAlert.setTitle("Confirmation Prompt");
        myAlert.setHeaderText("Exit Game");
        myAlert.setContentText("Are you sure, you want to exit?");
        if(myAlert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage) closeBtnHome.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    Button loadBtnHome;
    public void clicked_load_btn_home(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("load_game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) loadBtnHome.getScene().getWindow();
        stage.setTitle("Will Hero - Load Game");
        stage.setScene(scene);
    }

    @FXML
    Button leaderBoardBtnHome;
    public void clicked_leader_board_btn_home(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leader_board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) leaderBoardBtnHome.getScene().getWindow();
        stage.setTitle("Will Hero - Leaderboard");
        stage.setScene(scene);
    }

//    ---------------------------------------- LeaderBoard ------------------------------------------
    public void clicked_close_btn_leader_board(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) closeBtnLeaderBoard.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

//    ---------------------------------------- Load Game ------------------------------------------
    public void clicked_close_btn_load_game(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

//    ---------------------------------------- Game Play ------------------------------------------
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


//    ---------------------------------------- Game Result ------------------------------------------
    public void clicked_home_btn_game_result(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) homeBtnGameResult.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

}