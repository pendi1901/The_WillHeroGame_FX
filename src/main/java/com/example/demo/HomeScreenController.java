package com.example.demo;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {
    private GameMain myGame = GameMain.getInstance();

    //    ---------------------------------------- Animations ------------------------------------------
    @FXML
    ImageView heroHome;
    @FXML
    ImageView greenOrcHome;
    @FXML
    ImageView redOrcHome;
    @FXML
    Button playBtnHome;

    PlayMusic btnClick = new PlayMusic("src/main/resources/assets/Audio/btnClick.wav");
    PlayMusic gameStart = new PlayMusic("src/main/resources/assets/Audio/gamePlay.mp3");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(myGame.getMyMusic()==null){
            myGame.setMyMusic(gameStart);
            gameStart.play();
        }
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
    }

    //    ---------------------------------------- Home Screen ------------------------------------------
    public void clicked_play_btn_home(ActionEvent e) throws IOException {
        btnClick.play();

        TextInputDialog td = new TextInputDialog("");
        td.setHeaderText("Enter your name");
        Optional<String> result = td.showAndWait();
        btnClick.play();
        // ok was pressed.
        if (result.isPresent()) {
            TextField input = td.getEditor();
            if(input.getText()!= null && input.getText().trim().replaceAll(" +", " ").length()!=0){
//                Set name of player
                myGame.getCurrPlayer().setName(input.getText().trim().replaceAll(" +", " "));
//                Set game configurations
                myGame.newGame();
                myGame.getMyMusic().stop();
                myGame.setMyMusic(null);

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_play.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 680, 380);
                myGame.setMyScene(scene);
                Stage stage = (Stage) playBtnHome.getScene().getWindow();
                stage.setTitle("Will Hero - Playing Game");
                stage.setScene(scene);
            }
        }
    }

    @FXML
    Button closeBtnHome;
    public void clicked_close_btn_home(ActionEvent e)  {
        btnClick.play();
        Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
        myAlert.setTitle("Confirmation Prompt");
        myAlert.setHeaderText("Exit Game");
        myAlert.setContentText("Are you sure, you want to exit?");
        ButtonType t = myAlert.showAndWait().get();
        btnClick.play();
        if(t == ButtonType.OK){
            Stage stage = (Stage) closeBtnHome.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    Button loadBtnHome;
    public void clicked_load_btn_home(ActionEvent e) throws IOException {
        btnClick.play();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("load_game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) loadBtnHome.getScene().getWindow();
        stage.setTitle("Will Hero - Load Game");
        stage.setScene(scene);
    }

    @FXML
    Button leaderBoardBtnHome;
    public void clicked_leader_board_btn_home(ActionEvent e) throws IOException {
        btnClick.play();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leader_board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 380);
        Stage stage = (Stage) leaderBoardBtnHome.getScene().getWindow();
        stage.setTitle("Will Hero - Leaderboard");
        stage.setScene(scene);
    }

}