package Test;

import Program.Die;

public class DieTest {
    public static void main (String[] args) {
        Die die1 = new Die (6);
        Die die2 = new Die (6);
        int n2 =0;
        int n3 =0;
        int n4 =0;
        int n5 =0;
        int n6 =0;
        int n7 =0;
        int n8 =0;
        int n9 =0;
        int n10 =0;
        int n11 =0;
        int n12 =0;
        int toEns = 0;
        int sum =0;

        for (int i= 1; i<1000; i++){
            die1.roll();
            die2.roll();
            sum = (die1.getFaceValue()+die2.getFaceValue());

            switch (sum){
                case 2:
                n2++;
                break;

                case 3:
                n3++;
                break;

                case 4:
                n4++;
                break;

                case 5:
                n5++;
                break;

                case 6:
                n6++;
                break;

                case 7:
                n7++;
                break;

                case 8:
                n8++;
                break;

                case 9:
                n9++;
                break;

                case 10:
                n10++;
                break;
                case 11:
                n11++;
                break;

                case 12:
                n12++;
                break;



            }
            if(die1.getFaceValue() == die2.getFaceValue()){
                toEns++;
            }

        }
        System.out.println(""+n2);
        System.out.println(""+n3);
        System.out.println(""+n4);
        System.out.println(""+n5);
        System.out.println(""+n6);
        System.out.println(""+n7);
        System.out.println(""+n8);
        System.out.println(""+n9);
        System.out.println(""+n10);
        System.out.println(""+n11);
        System.out.println(""+n12);
        System.out.println("to ens"+toEns);


    }


 }


