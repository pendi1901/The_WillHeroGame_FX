package com.example.demo;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaderBoardController implements Initializable {
    private GameMain myGame = GameMain.getInstance();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView crownBtnLeaderBoard;
    @FXML
    Button closeBtnLeaderBoard;

    @FXML
    Label LblName1 ;
    @FXML
    Label LblName2;
    @FXML
    Label LblName3;
    @FXML
    Label LblName4;
    @FXML
    Label LblName5;
    @FXML
    Label LblScore1;
    @FXML
    Label LblScore2;
    @FXML
    Label LblScore3;
    @FXML
    Label LblScore4;
    @FXML
    Label LblScore5;


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

        {
            int count = GameResultController.LinkedListSorter.getInstance().getcount();
            if (count == 1) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            } else if (count == 2) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore2.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            } else if (count == 3) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore2.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore3.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            } else if (count == 4) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(3));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(3)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore2.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore3.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore4.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            } else if (count == 5) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(4));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(4)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(3));
                LblScore2.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(3)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore3.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore4.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName5.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore5.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            } else if (count > 5) {
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 1));
                LblScore1.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 1)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 2));
                LblScore2.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 2)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 3));
                LblScore3.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 3)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 4));
                LblScore4.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 4)));
                LblName5.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 5));
                LblScore5.setText(Float.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 5)));
            }
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