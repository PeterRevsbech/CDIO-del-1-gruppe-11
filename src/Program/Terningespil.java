
package Program;
import java.util.*;
public class Terningespil {

    public static void main(String[] args) {
	// Vi initialiserer
        //Opretter spillere og terninger
        Scanner in = new Scanner(System.in);
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Player p1 = new Player();
        Player p2 = new Player();



        //Opretter variable
        int counter = 1; //Angiver om det spiller 1(ved lige) eller spiller 2(ved lige)

        while(true){



            break;
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
}
