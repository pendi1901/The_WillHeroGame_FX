package com.example.demo;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {
    private GameMain myGame = GameMain.getInstance();
    private ArrayList<ImageView> myPlatformImages = new ArrayList<>();
    private ArrayList<Pair<ImageView, Integer>> myObjWithType = new ArrayList<>();

    //    ---------------------------------------- Animations ------------------------------------------

    @FXML
    ImageView heroHome;
    @FXML
    ImageView greenOrcHome;
    @FXML
    ImageView redOrcHome;

    @FXML
    ImageView heroGamePlay;
    @FXML
    ImageView platform1;
    @FXML
    ImageView platform2;
    @FXML
    ImageView platform3;
    @FXML
    ImageView platform4;
    @FXML
    ImageView platform5;
    @FXML
    ImageView greenOrcGamePlay;
    @FXML
    ImageView redOrcGamePlay;
    @FXML
    ImageView bossOrcGamePlay;
    @FXML
    ImageView princessGamePlay;
    @FXML
    ImageView throwingKnifeGamePlay;
    @FXML
    ImageView swordGamePlay;
    @FXML
    ImageView coinChest;
    @FXML
    ImageView weaponChest;
    @FXML
    ImageView tnt;
    @FXML
    ImageView finalCoinChest;

    @FXML
    Label coinsCollectedGamePlay;
    @FXML
    Label pointsScoredGamePlay;
    @FXML
    Button pauseBtnGamePlay;


    @FXML
    Button closeBtnPauseGame;
    @FXML
    Button playBtnPauseGame;
    @FXML
    Button reviveBtnGameOver;

    private boolean moveX = false;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>(){
        double deltaY = 1;
        double g = 0.02;
        double deltaX = 3;
        double deltaXR = 1.5;
        @Override
        public void handle(ActionEvent actionEvent) {
            if(moveX){
                if(myGame.getCurrPlayer().getMoveX()==1){
                    heroGamePlay.setLayoutX(heroGamePlay.getLayoutX()+deltaX);
                    if(heroGamePlay.getLayoutX()>=80){
                        myGame.getCurrPlayer().toggleMoveX();
                    }
                }
                else{
                    heroGamePlay.setLayoutX(heroGamePlay.getLayoutX()-deltaXR);
                    if(heroGamePlay.getLayoutX()<=60){
                        moveX = false;
                        myGame.getCurrPlayer().toggleMoveX();
                    }
                    return;
                }
            }
            heroGamePlay.setLayoutY(heroGamePlay.getLayoutY() + deltaY);
            deltaY += g;
            int isCollided = -1;
            try {
                isCollided = checkCollision();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (isCollided == 0) {
                deltaY *= -1;
                myGame.getCurrPlayer().setPrevStart((int) heroGamePlay.getLayoutY());
            } else if (heroGamePlay.getLayoutY() + myGame.getCurrPlayer().getJumpHeight() < myGame.getCurrPlayer().getPrevStart()) {
                deltaY *= -1;
            }
//            jumpHero(deltaX, deltaY, g, deltaXR);
        }
    }));

    public void makeVisible(ImageView img_v, Platform p){
        img_v.setVisible(true);
        img_v.setLayoutX(p.getInf().getX()+p.getInf().getLen()/2);
        img_v.setLayoutY(p.getInf().getY()-img_v.getFitHeight());
    }

    public void makeHide(ImageView img_v, int type){
        for (int i = 0; i < myObjWithType.size(); i++) {
            if (myObjWithType.get(i).getKey() == img_v && myObjWithType.get(i).getValue() == type) {
                myObjWithType.remove(i);
                break;
            }
        }
        img_v.setVisible(false);
    }

    public void setupPlatform(int idx){
        int i = (idx%4 >= 0 ? idx%4: idx%4 + 4);

//        hide obj previously placed
        if(myObjWithType.size()!=0 && myObjWithType.get(0).getKey().getLayoutX()<0){
            makeHide(myObjWithType.get(0).getKey(), myObjWithType.get(0).getValue());
        }

//        setup platform to extreme right
        myGame.getCurrPlatforms().get(i).getInf().setX(myGame.getCurrPlatforms().get(i-1<0?3:i-1).getInf().getX() + (i-1<0?280-40:280));
        myPlatformImages.get(i).setLayoutX(myGame.getCurrPlatforms().get(i).getInf().getX());
        Platform p = myGame.getCurrPlatforms().get(i);

        switch (myGame.getObjOnPlatforms().get(idx)){
            // 0 - E; 1 - GO; 2 - RO; 3 - CC; 4 - WC; 5 - TNT; 6 - B,FC,P
            case 1:
                makeVisible(greenOrcGamePlay, p);
                myObjWithType.add(new Pair(greenOrcGamePlay, 1));
                break;
            case 2:
                makeVisible(redOrcGamePlay, p);
                myObjWithType.add(new Pair(redOrcGamePlay, 2));
                break;
            case 3:
                makeVisible(coinChest, p);
                myObjWithType.add(new Pair(coinChest, 3));
                break;
            case 4:
                makeVisible(weaponChest, p);
                myObjWithType.add(new Pair(weaponChest, 4));
                break;
            case 5:
                makeVisible(tnt, p);
                myObjWithType.add(new Pair(tnt, 5));
                break;
        }
    }

    public void degradePlatform(int i){
        myPlatformImages.get(i).setVisible(false);
    }

    public void lastStep(){
        platform5.setLayoutX(platform4.getLayoutX()+280);
        platform5.setLayoutY(240);
        platform5.setVisible(true);

        bossOrcGamePlay.setVisible(true);
        bossOrcGamePlay.setLayoutX(platform5.getLayoutX()+50);
        bossOrcGamePlay.setLayoutY(platform5.getLayoutY()-bossOrcGamePlay.getFitHeight());
        princessGamePlay.setVisible(true);
        princessGamePlay.setLayoutX(platform5.getLayoutX()+200);
        princessGamePlay.setLayoutY(platform5.getLayoutY()-princessGamePlay.getFitHeight());
        finalCoinChest.setVisible(true);
        finalCoinChest.setLayoutX(platform5.getLayoutX()+280);
        finalCoinChest.setLayoutY(platform5.getLayoutY()-finalCoinChest.getFitHeight());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Hero
//        if(heroHome!=null){
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

        if(heroGamePlay!=null){
            heroGamePlay.setLayoutX(myGame.getCurrPlayer().getCurrX());
            heroGamePlay.setLayoutY(130);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
//        Set platform images
        if(platform1!=null){
            platform5.setVisible(false);
            redOrcGamePlay.setVisible(false);
            greenOrcGamePlay.setVisible(false);
            bossOrcGamePlay.setVisible(false);
            princessGamePlay.setVisible(false);
            coinChest.setVisible(false);
            weaponChest.setVisible(false);
            finalCoinChest.setVisible(false);
            throwingKnifeGamePlay.setVisible(false);
            swordGamePlay.setVisible(false);
            tnt.setVisible(false);

            myPlatformImages = new ArrayList<>();
            myObjWithType = new ArrayList<>();
            platform1.setLayoutX(myGame.getCurrPlatforms().get(0).getInf().getX());
            platform1.setLayoutY(myGame.getCurrPlatforms().get(0).getInf().getY());
            myPlatformImages.add(platform1);
            platform2.setLayoutX(myGame.getCurrPlatforms().get(1).getInf().getX());
            platform2.setLayoutY(myGame.getCurrPlatforms().get(1).getInf().getY());
            myPlatformImages.add(platform2);
            platform3.setLayoutX(myGame.getCurrPlatforms().get(2).getInf().getX());
            platform3.setLayoutY(myGame.getCurrPlatforms().get(2).getInf().getY());
            myPlatformImages.add(platform3);
            platform4.setLayoutX(myGame.getCurrPlatforms().get(3).getInf().getX());
            platform4.setLayoutY(myGame.getCurrPlatforms().get(3).getInf().getY());
            myPlatformImages.add(platform4);

            if(myGame.getDoneTill()==4) {
                makeVisible(greenOrcGamePlay, myGame.getCurrPlatforms().get(2));
                myObjWithType.add(new Pair(greenOrcGamePlay, 1));
                makeVisible(coinChest, myGame.getCurrPlatforms().get(3));
                myObjWithType.add(new Pair(coinChest, 3));
            }

            pauseBtnGamePlay.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    move();
                }
            });

            pointsScoredGamePlay.setText(Integer.toString((int)myGame.getCurrPlayer().getPoints()));
        }

    }

//    0 for normal with platform; 1 for orc (win); 2 for orc (lose); 3 for coins chest; 4 for weapon chest
    public int checkCollision() throws IOException {
//        collision with platforms
        for (int i = 0; i < 4; i++) {
            if(heroGamePlay.getBoundsInParent().intersects(myPlatformImages.get(i).getBoundsInParent())){
                if((heroGamePlay.getLayoutY()+heroGamePlay.getFitHeight()) - myPlatformImages.get(i).getLayoutY() < 2){
                    return 0;
                }
            }
        }
        if(myGame.getDoneTill()>=37){
            if(heroGamePlay.getBoundsInParent().intersects(platform5.getBoundsInParent())){
                if((heroGamePlay.getLayoutY()+heroGamePlay.getFitHeight()) - platform5.getLayoutY() < 2){
                    return 0;
                }
            }
        }
//        game over
        if(heroGamePlay.getLayoutY()>260){
            timeline.stop();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_over.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 380);
            Stage stage = (Stage) heroGamePlay.getScene().getWindow();
            stage.setTitle("Will Hero - Game Over");
            stage.setScene(scene);
        }
        return -1;
    }

    //    ---------------------------------------- Game Play ------------------------------------------
    public void move(){
        int changeXBy = 40;
        moveX = true;
        myGame.getCurrPlayer().changePoints(myGame.getCurrPlayer().getPoints()<130?0.5:0);
        pointsScoredGamePlay.setText(Integer.toString((int)myGame.getCurrPlayer().getPoints()));
        for (int i = 0; i < 4; i++) {
            Inf tempInf = myGame.getCurrPlatforms().get(i).getInf();
            if (tempInf.getX() + tempInf.getLen() < 0) {
//              System.out.println(myPlatformImages.get(i).getLayoutX()+" oops");
//                myGame.getCurrPlatforms().get(i).getInf().setX(myGame.getCurrPlatforms().get(i-1<0?3:i-1).getInf().getX() + (i-1<0?280-changeXBy:280));
                if(myGame.getDoneTill()>=36){
                    if(myGame.getDoneTill()==36){
                        lastStep();
                        myGame.changeDoneTill();
                    }
                    degradePlatform(i);
                }
                else {
                    setupPlatform(myGame.getDoneTill());
                    myGame.changeDoneTill();
                }
            } else {
//              System.out.println(myPlatformImages.get(i).getLayoutX()+" ok");
                myGame.getCurrPlatforms().get(i).getInf().changeX(-changeXBy);
                myPlatformImages.get(i).setLayoutX(myGame.getCurrPlatforms().get(i).getInf().getX());
            }
        }
        for (int i = 0; i < myObjWithType.size(); i++) {
            myObjWithType.get(i).getKey().setLayoutX(myObjWithType.get(i).getKey().getLayoutX()-40);
        }
        if(myGame.getDoneTill()>=37 && myGame.getDoneTill()<=58){
            platform5.setLayoutX(platform5.getLayoutX()-40);
            bossOrcGamePlay.setLayoutX(bossOrcGamePlay.getLayoutX()-40);
            princessGamePlay.setLayoutX(princessGamePlay.getLayoutX()-40);
            finalCoinChest.setLayoutX(finalCoinChest.getLayoutX()-40);
            myGame.changeDoneTill();
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
//        timer.start();
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