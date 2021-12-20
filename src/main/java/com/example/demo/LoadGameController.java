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

public class LoadGameController implements Initializable {
    private GameMain myGame = GameMain.getInstance();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    Button closeBtnLoadGame;

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
    }

    //    ---------------------------------------- Load Game ------------------------------------------
    public void clicked_close_btn_load_game(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) closeBtnLoadGame.getScene().getWindow();
        stage.setTitle("Will Hero - Home");
        stage.setScene(scene);
    }

}