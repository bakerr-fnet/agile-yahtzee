package yahtzee;

import java.util.Random;

public class DieRoller implements IDieRoller {

    private Random r = new Random();

    public int roll() {
        return r.nextInt(6) + 1;
    }


}
