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
    Label noDisplayTxt;
    @FXML
    Label r1;
    @FXML
    Label r2;
    @FXML
    Label r3;
    @FXML
    Label r4;
    @FXML
    Label r5;
    @FXML
    Label LblName1;
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
//        Show leaderboard content
        {
            noDisplayTxt.setVisible(false);
            r1.setVisible(false);r2.setVisible(false);r3.setVisible(false);r4.setVisible(false);r5.setVisible(false);
            LblName1.setVisible(false);
            LblName2.setVisible(false);
            LblName3.setVisible(false);
            LblName4.setVisible(false);
            LblName5.setVisible(false);
            LblScore1.setVisible(false);
            LblScore2.setVisible(false);
            LblScore3.setVisible(false);
            LblScore4.setVisible(false);
            LblScore5.setVisible(false);

            int count = GameResultController.LinkedListSorter.getInstance()==null?0:GameResultController.LinkedListSorter.getInstance().getcount();
            if (count <= 0){
                noDisplayTxt.setVisible(true);
            }
            else if (count == 1) {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            }
            else if (count == 2) {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName2.setVisible(true); r2.setVisible(true);
                LblScore2.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore2.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            }
            else if (count == 3) {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName2.setVisible(true); r2.setVisible(true);
                LblScore2.setVisible(true);
                LblName3.setVisible(true); r3.setVisible(true);
                LblScore3.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore2.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore3.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            }
            else if (count == 4) {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName2.setVisible(true); r2.setVisible(true);
                LblScore2.setVisible(true);
                LblName3.setVisible(true); r3.setVisible(true);
                LblScore3.setVisible(true);
                LblName4.setVisible(true); r4.setVisible(true);
                LblScore4.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(3));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(3)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore2.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore3.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore4.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            }
            else if (count == 5) {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName2.setVisible(true); r2.setVisible(true);
                LblScore2.setVisible(true);
                LblName3.setVisible(true); r3.setVisible(true);
                LblScore3.setVisible(true);
                LblName4.setVisible(true); r4.setVisible(true);
                LblScore4.setVisible(true);
                LblName5.setVisible(true); r5.setVisible(true);
                LblScore5.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(4));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(4)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(3));
                LblScore2.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(3)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(2));
                LblScore3.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(2)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(1));
                LblScore4.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(1)));
                LblName5.setText(GameResultController.LinkedListSorter.getInstance().getNthname(0));
                LblScore5.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(0)));
            }
            else {
                LblName1.setVisible(true); r1.setVisible(true);
                LblScore1.setVisible(true);
                LblName2.setVisible(true); r2.setVisible(true);
                LblScore2.setVisible(true);
                LblName3.setVisible(true); r3.setVisible(true);
                LblScore3.setVisible(true);
                LblName4.setVisible(true); r4.setVisible(true);
                LblScore4.setVisible(true);
                LblName5.setVisible(true); r5.setVisible(true);
                LblScore5.setVisible(true);
                LblName1.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 1));
                LblScore1.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 1)));
                LblName2.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 2));
                LblScore2.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 2)));
                LblName3.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 3));
                LblScore3.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 3)));
                LblName4.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 4));
                LblScore4.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 4)));
                LblName5.setText(GameResultController.LinkedListSorter.getInstance().getNthname(count - 5));
                LblScore5.setText(Integer.toString(GameResultController.LinkedListSorter.getInstance().getNthno(count - 5)));
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