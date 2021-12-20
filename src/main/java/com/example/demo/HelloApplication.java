package com.example.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private GameMain myGame = GameMain.getInstance();
    @Override
    public void start(Stage stage) throws IOException {
//        home_screen game_play game_over game_result game_pause load_game leader_board

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);

        stage.setTitle("Will Hero - Home");
        stage.getIcons().add(new Image("file:///D:/My Files/ARS@IIITD/Academics/Year 2/Sem3/AP/AP Project/Will Hero/refer/Images/boss orc.png"));
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exitGame(stage);
        });
    }

    public void exitGame(Stage stage){
        Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
        myAlert.setTitle("Confirmation Prompt");
        myAlert.setHeaderText("Exit Game");
        myAlert.setContentText("Are you sure, you want to exit?");
        if(myAlert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}