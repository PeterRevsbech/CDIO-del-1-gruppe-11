package Program;
import java.util.*;

public class Die {

    private int sideNummer = 6;
    private int faceValue = 1;

    public Die(int i) {
        sideNummer = i;
    }


    public void roll(){
        Random Ran = new Random();
        faceValue = Ran.nextInt(sideNummer) + 1;
    }

    public int getFaceValue(){
        return faceValue;
    }

    public void setFaceValue(int y){
        faceValue = y;
    }

    public String toString(){
        return Integer.toString(faceValue);
    }



}
