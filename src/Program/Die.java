package Program;
import java.util.*;

public class Die {

    private int sideNummer = 6;
    private int faceValue = 1;

    public void Die(int x) {
        sideNummer = x;
    }

    public void roll(){
        Random Ran = new Random();
        faceValue = Ran.nextInt(sideNummer) + 1;
    }

    private int getFaceValue(){
        return faceValue;
    }

    private void setFaceValue(int y){
        faceValue = y;
    }

    private String toString(){
        return Integer.toString(faceValue);
    }



}
