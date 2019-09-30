package Program;

public class Player {

    private int point = 0;
    private String PlayerNavn = "Ukendt";
    private boolean toSeksereSidst = false;

    //konstruktør
    public void Player(String navn){
        PlayerNavn = navn;

    }

    public void setPoint(int x){
        point = x;
    }

    public int getPoint(){
        return point;
    }

    public void setToSeksereSidst(boolean X) {
        toSeksereSidst = X;
    }

    public boolean getToSeksereSidst() {
        return toSeksereSidst;
    }

    public void setPlayerNavn(String navn) {
        PlayerNavn = navn;
    }
    public String getPlayerNavn() {
        return PlayerNavn;
    }




}
