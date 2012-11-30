package yahtzee;

import java.util.Random;

public class DieRoller implements IDieRoller {


    public int roll() {
        Random r = new Random();
        return  r.nextInt(6) + 1;
    }


}
