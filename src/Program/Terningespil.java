
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
        final int POINTLIMIT = 40;
        int runde = 1;

        // Selve terningespillet kører så længe while-loopet kører.
        while(true){

            //Terningerne rulles
            die1.roll();
            die2.roll();

            //Enten p1's tur eller p2's
            if (counter%2==1) { //Det er spiller 1's tur

                if(p1.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                    System.out.println("Spiller 1 har vundet");
                    break;
                }

                //Pointgivning
                p1.setPoint(p1.getPoint() + getSum(die1.getFaceValue(),die2.getFaceValue()));

                if (die1.getFaceValue()==die2.getFaceValue() && die1.getFaceValue()==1) {
                    p1.setPoint(0);
                }

                //To seksere
                if (die1.getFaceValue()==6 && die2.getFaceValue()==6) {
                    if (p1.getToSeksereSidst()) {

                        System.out.println("Spiller 1 har vundet"); //SKAL SLETTES SENERE
                        break;
                    } else {
                        p1.setToSeksereSidst(true);
                        }
                    } else {
                    p1.setToSeksereSidst(false);
                }

            } else { //Det er spiller 2's tur

                //Tjek om man har vundet
                if(p1.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                    System.out.println("Spiller 2 har vundet");
                    break;
                }

                //pointgivning
                p2.setPoint(p2.getPoint() + getSum(die1.getFaceValue(),die2.getFaceValue()));

                if (die1.getFaceValue()==die2.getFaceValue() && die1.getFaceValue()==1) {
                    p2.setPoint(0);
                }

                //To seksere
                if (die1.getFaceValue()==6 && die2.getFaceValue()==6) {
                    if (p2.getToSeksereSidst()) {

                        System.out.println("Spiller 2 har vundet"); //SKAL SLETTES SENERE
                        break;
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
             }
            }
        }

    public static int getSum(int x1, int x2){
        return x1+x2;
    }

    public static boolean getEns(int x1, int x2){
        return x1 == x2;
    }
}
