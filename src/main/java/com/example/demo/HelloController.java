package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    Button btn_screen_1;
    public void show_screen_2(ActionEvent e) throws IOException {
        Scene scene = btn_screen_1.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leader_board.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Leaderboard");
        stage.setScene(scene);
    }

    @FXML
    Button btn_screen_2;
    public void show_screen_3(ActionEvent e) throws IOException {
        Scene scene = btn_screen_2.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("load_game.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Load Game");
        stage.setScene(scene);
    }
    @FXML
    Button btn_screen_3;
    public void show_screen_4(ActionEvent e) throws IOException {
        Scene scene = btn_screen_3.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Playing Game");
        stage.setScene(scene);
    }
    @FXML
    Button btn_screen_4;
    public void show_screen_5(ActionEvent e) throws IOException {
        Scene scene = btn_screen_4.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_pause.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Game Paused");
        stage.setScene(scene);
    }
    @FXML
    Button btn_screen_5;
    public void show_screen_6(ActionEvent e) throws IOException {
        Scene scene = btn_screen_5.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_over.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Game Over");
        stage.setScene(scene);
    }
    @FXML
    Button btn_screen_6;
    public void show_screen_7(ActionEvent e) throws IOException {
        Scene scene = btn_screen_6.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_result.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Result");
        stage.setScene(scene);
    }
    @FXML
    Button btn_screen_7;
    public void show_screen_1(ActionEvent e) throws IOException {
        Scene scene = btn_screen_7.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home_screen.fxml"));
        scene = new Scene(fxmlLoader.load(), 680, 380);
        stage.setTitle("Will Hero - Home Screen");
        stage.setScene(scene);
    }


}