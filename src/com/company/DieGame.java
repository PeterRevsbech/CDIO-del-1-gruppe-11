package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;
public class DieGame extends Application {
    // public variebuls
    public int playerNumber;
    // counter controllers

    private int i = 0;
    // text boxes
    Text player1 = new Text(50,50,"player 1:");
    Text player2 = new Text(50,70,"player 2:");
    Text player3 = new Text(50,90,"player 3");
    Text player4 = new Text(50,110,"player 4");
    Text dieOne = new Text(50,20,"");
    Text dieTwo = new Text(160,20,"");
    // buttons
    Button dieRoller = new Button("begin game");
    Button resetButton = new Button("Reset Game");
    public void start(Stage primaryStage) {
        //



        //Text player = new Text("player: 1");

        dieRoller.setOnAction(this::rollDie);
        dieRoller.setLayoutX(50.0);
        dieRoller.setLayoutY(130.0);
        resetButton.setOnAction(this::resetGame);
        resetButton.setLayoutX(100.0);
        resetButton.setLayoutY(130.0);
        resetButton.setVisible(false);
        player1.setVisible(true);
        player2.setVisible(true);
        player3.setVisible(true);
        player4.setVisible(true);

        Group root = new Group(player1,player2,player3,player4,dieOne,dieTwo,dieRoller,resetButton);
        Scene scene = new Scene(root,300,300, Color.GOLD);
        primaryStage.setTitle("!!Die Game!!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void rollDie(ActionEvent event){
        // commince game

        if(i == 0 ){
            i++;
        }
        int dieOneRolled = (int)(Math.random() * 6 + 1);
        int dieTwoRolled = (int)(Math.random() * 6 + 1);
        dieOne.setText("Player: "+i+" Rolled: "+dieOneRolled );
        dieTwo.setText("Player: "+i+" Rolled: "+dieTwoRolled );
        switch (i){
            case 1:
                player1.setVisible(true);
                player2.setVisible(false);
                player3.setVisible(false);
                player4.setVisible(false);
                player1.setText("player"+i+": ");
                if(dieOneRolled == dieTwoRolled){
                    player1.setText("player1: you won");
                    dieRoller.setVisible(false);
                    resetButton.setVisible(true);
                    i = 0;
                }


                i++;
                break;
            case 2:
                player1.setVisible(false);
                player2.setVisible(true);
                player3.setVisible(false);
                player4.setVisible(false);
                player2.setText("player"+i+": ");
                if(dieOneRolled == dieTwoRolled){
                    player2.setText("player2: you won");
                    dieRoller.setVisible(false);
                    resetButton.setVisible(true);
                    i = 0;
                }


                i++;
                break;
            case 3:
                player1.setVisible(false);
                player2.setVisible(false);
                player3.setVisible(true);
                player4.setVisible(false);
                player3.setText("player"+i+": ");
                if(dieOneRolled == dieTwoRolled){
                    player3.setText("player3: you won");
                    dieRoller.setVisible(false);
                    resetButton.setVisible(true);
                    i = 0;
                }


                i++;
                break;
            case 4:
                player1.setVisible(false);
                player2.setVisible(false);
                player3.setVisible(false);
                player4.setVisible(true);
                player4.setText("player"+i+": ");
                if(dieOneRolled == dieTwoRolled){
                    player4.setText("player4: you won");
                    dieRoller.setVisible(false);
                    resetButton.setVisible(true);
                    i = 0;
                }


                i= 1;
                break;
        }

    }
    public void resetGame(ActionEvent event){
        player1.setVisible(true);
        player2.setVisible(true);
        player3.setVisible(true);
        player4.setVisible(true);
        dieRoller.setText("Begin Game");
        dieRoller.setVisible(true);
        resetButton.setVisible(false);
    }


}
