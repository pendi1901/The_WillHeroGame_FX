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

public class LeaderBoardController implements Initializable {
    private GameMain myGame = GameMain.getInstance();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView crownBtnLeaderBoard;
    @FXML
    Button closeBtnLeaderBoard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    }

    //    ---------------------------------------- LeaderBoard ------------------------------------------
    public void clicked_close_btn_leader_board(ActionEvent e) throws IOException {
        PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
        btnClick.play();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) closeBtnLeaderBoard.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

}