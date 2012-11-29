package yahtzee;

import java.util.Random;

public class Die implements IDie {

    int value = -1;

    public Die()
    {
        roll();
    }

    public void roll() {
        Random r = new Random();
        value = r.nextInt(6) + 1;
    }


    public int getValue() {
        return value;
    }
}
