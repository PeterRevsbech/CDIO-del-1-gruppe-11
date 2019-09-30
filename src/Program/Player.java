package Program;

public class Player {

    private int point = 0;
    private String PlayerNavn = "Ukendt";

    //konstruktør
    public void Player(String navn){
        PlayerNavn = navn;

    }

    public void givPoint(int x){
        point = x + point;
    }

    public int getPoint(){
        return point;
    }

}
