package Program;
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
    Text player1 = new Text(50, 70, "player 1:");
    Text player2 = new Text(50, 90, "player 2:");
    Text player3 = new Text(50, 110, "player 3");
    Text player4 = new Text(50, 130, "player 4");
    Text roundCounter = new Text(20, 20, "");
    Text dieOne = new Text(50, 40, "");
    Text dieTwo = new Text(160, 40, "");
    // buttons
    Button dieRoller = new Button("begin game");
    Button resetButton = new Button("Reset Game");

    public void start(Stage primaryStage) {
        //


        //Text player = new Text("player: 1");

        dieRoller.setOnAction(this::rollDie);
        dieRoller.setLayoutX(50.0);
        dieRoller.setLayoutY(150.0);
        resetButton.setOnAction(this::resetGame);
        resetButton.setLayoutX(100.0);
        resetButton.setLayoutY(150.0);
        resetButton.setVisible(false);
        player1.setVisible(true);
        player2.setVisible(true);
        player3.setVisible(true);
        player4.setVisible(true);

        Group root = new Group(player1, player2, player3, player4,roundCounter, dieOne, dieTwo, dieRoller, resetButton);
        Scene scene = new Scene(root, 300, 300, Color.GOLD);
        primaryStage.setTitle("!!Die Game!!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    Die die1 = new Die(6);
    Die die2 = new Die(6);
    Player p1 = new Player();
    Player p2 = new Player();



    //Opretter variable
    int counter = 1; //Angiver om det spiller 1(ved lige) eller spiller 2(ved lige)
    final int POINTLIMIT = 40;
    int runde = 1;



    public void rollDie(ActionEvent event) {
    //Terningerne rulles
            die1.roll();
            die2.roll();

            switch (die1.getFaceValue()){

            }
            switch (die2.getFaceValue()){

            }
        dieOne.setText("die 1 rolled: "+ die1.getFaceValue());
        dieTwo.setText("die 2 rolled: "+ die2.getFaceValue());
        //Enten p1's tur eller p2's
        if (counter%2==1) { //Det er spiller 1's tur

            if(p1.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                player1.setText("Spiller 1 har vundet");
                dieRoller.setVisible(false);
            }


            //Pointgivning
            p1.setPoint(p1.getPoint() + getSum(die1.getFaceValue(),die2.getFaceValue()));

            if (die1.getFaceValue()==die2.getFaceValue() && die1.getFaceValue()==1) {
                p1.setPoint(0);

            }
            if(!(p1.getPoint() >= POINTLIMIT && die1.getFaceValue() == die2.getFaceValue())){
                player1.setText("Player 1: " +p1.getPoint());

            }
            //To seksere
            if (die1.getFaceValue()==6 && die2.getFaceValue()==6) {

                if (p1.getToSeksereSidst()) {

                   player1.setText("Spiller 1 har vundet"); //SKAL SLETTES SENERE
                } else {
                    p1.setToSeksereSidst(true);
                }
            } else {
                p1.setToSeksereSidst(false);
            }





        }

        else { //Det er spiller 2's tur

            //Tjek om man har vundet
            if(p1.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                player2.setText("Spiller 2 har vundet");
            }

            //pointgivning
            p2.setPoint(p2.getPoint() + getSum(die1.getFaceValue(),die2.getFaceValue()));

            if (die1.getFaceValue()==die2.getFaceValue() && die1.getFaceValue()==1) {
                p2.setPoint(0);
            }
            if(!(p2.getPoint() >= POINTLIMIT && die1.getFaceValue() == die2.getFaceValue())){
                player2.setText("Player 2: " +p2.getPoint());

            }
            //To seksere
            if (die1.getFaceValue()==6 && die2.getFaceValue()==6) {
                if (p2.getToSeksereSidst()) {

                    player2.setText("Spiller 2 har vundet"); //SKAL SLETTES SENERE

                } else {
                    p2.setToSeksereSidst(true);
                }
            } else {
                p2.setToSeksereSidst(false);
            }
        }

        //Håndtering af ture og omslag


        if (die1.getFaceValue()!=die2.getFaceValue()) {
            counter++;
            runde = runde + counter%2;
            roundCounter.setText("runde: "+runde);





        }



    }








    public static int getSum(int x1, int x2){
        return x1+x2;
    }

    public static boolean getEns(int x1, int x2){
        return x1 == x2;
    }

    //public void rollDice(Player spiller){
    //    die1.roll();
    //    die2.roll();
    //    spiller.givPoint(getSum(die1.faceValue,die2.faceValue));
    //}
        /*// commince game
        if(i == 1){
            roundtcounter++;
        }
        roundCounter.setText("round: "+ roundtcounter);
        if (i == 0) {
            i++;
        }
        int dieOneRolled = (int) (Math.random() * 6 + 1);
        int dieTwoRolled = (int) (Math.random() * 6 + 1);
        dieOne.setText("Player: " + i + " Rolled: " + dieOneRolled);
        dieTwo.setText("Player: " + i + " Rolled: " + dieTwoRolled);
        switch (i) {
            case 1:
                player1.setVisible(true);
                player2.setVisible(false);
                player3.setVisible(false);
                player4.setVisible(false);
                player1.setText("player" + i + ": " );
                if (dieOneRolled == dieTwoRolled) {
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
                player2.setText("player" + i + ": " );
                if (dieOneRolled == dieTwoRolled) {
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
                player3.setText("player" + i + ": " );
                if (dieOneRolled == dieTwoRolled) {
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
                player4.setText("player" + i + ": " );
                if (dieOneRolled == dieTwoRolled) {
                    player4.setText("player4: you won");
                    dieRoller.setVisible(false);
                    resetButton.setVisible(true);
                    i = 0;
                }


                i = 1;

                break;
        }

         */

    public void resetGame(ActionEvent event) {
        player1.setVisible(true);
        player2.setVisible(true);
        player3.setVisible(true);
        player4.setVisible(true);
        dieRoller.setText("Begin Game");
        dieRoller.setVisible(true);
        resetButton.setVisible(false);
    }

}
