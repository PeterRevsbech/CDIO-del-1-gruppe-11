package Program;
import java.util.*;
import gui_fields.GUI_Player;
import gui_main.GUI;
public class Terningespil {

    public static void main(String[] args) {
	// Vi initialiserer
        //Opretter spillere og terninger
        Scanner in = new Scanner(System.in);
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Player p1 = new Player();
        Player p2 = new Player();
        GUI gui = new GUI();
        String  navn1 = gui.getUserString("Venligst indtast navnet på første spiller");
        String navn2 = gui.getUserString("Venligst indtast navnet på anden spiller");
        p1.setPlayerNavn(navn1);
        p2.setPlayerNavn(navn2);


        //Opretter variable
        int counter = 1; //Angiver om det spiller 1(ved lige) eller spiller 2(ved lige)
        final int POINTLIMIT = 40;
        int runde = 1;

        //Siger velkomnen
        gui.showMessage("Velkommen " + p1.getPlayerNavn() + " og " + p2.getPlayerNavn() );

        // Selve terningespillet kører så længe while-loopet kører.
        while(true){

            //Terningerne rulles
            die1.roll();
            die2.roll();
            gui.setDice(die1.getFaceValue(),die2.getFaceValue());
            if (counter%2==1) {
                gui.showMessage("Runde " + runde +"\nDet er " + p1.getPlayerNavn() +  "s tur \n" + p1.getPlayerNavn() +"s point: "+ p1.getPoint() +"\n" +p2.getPlayerNavn()+"s point: "  +p2.getPoint()+ "\n\nTryk OK for at kaste ");

            } else {
                gui.showMessage("Runde " + runde +"\nDet er " + p2.getPlayerNavn() +  "s tur \n" + p1.getPlayerNavn() +"s point: "+ p1.getPoint() +"\n" +p2.getPlayerNavn()+"s point: "  +p2.getPoint()+ "\n\nTryk OK for at kaste ");

            }




            //Enten p1's tur eller p2's
            if (counter%2==1) { //Det er spiller 1's tur

                if(p1.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                    gui.showMessage(p1.getPlayerNavn() + " har vundet ved dobbeltslag efter 40 point. " +p1.getPlayerNavn() + " sluttede med "+
                            p1.getPoint() + " point og "+ p2.getPlayerNavn()+" med " + p2.getPoint()+ " point.");
                    //System.out.println("Spiller 1 har vundet");
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
                        gui.showMessage(p1.getPlayerNavn() + " vandt med 2 seksere 2 gange i streg. Spiller 1 sluttede med " +
                                p1.getPoint() + " point og Spiller 2 med " + p2.getPoint()+ " point.");
                        //System.out.println("Spiller 1 har vundet"); //SKAL SLETTES SENERE
                        break;
                    } else {
                        p1.setToSeksereSidst(true);
                        }
                    } else {
                    p1.setToSeksereSidst(false);
                }

            } else { //Det er spiller 2's tur

                //Tjek om man har vundet
                if(p2.getPoint() >= POINTLIMIT && die1.getFaceValue()== die2.getFaceValue()){
                    gui.showMessage(p2.getPlayerNavn() + " har vundet ved dobbeltslag efter 40 point. " +p1.getPlayerNavn() + " sluttede med "+
                            p1.getPoint() + " point og "+ p2.getPlayerNavn()+" med " + p2.getPoint()+ " point.");
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
                        gui.showMessage(p2.getPlayerNavn()+" vandt med 2 seksere 2 gange i streg. Spiller 2 sluttede med " +
                                p2.getPoint() + " point og  Spiller 1 med " + p1.getPoint()+ " point.");
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
