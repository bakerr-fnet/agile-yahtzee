package yahtzee;

import java.util.Arrays;

public class Dice {

    private IDieRoller roller;
    private int[] dice;
    private boolean[] heldDice;


    public Dice (IDieRoller roller)
    {
        this.roller = roller;
        dice = new int[]{ 0,0,0,0,0 };
        heldDice = new boolean[]{false,false,false,false,false};
        roll();
    }

    public void roll()
    {
        for (int i=0;i<5;i++)
        {
            if (!heldDice[i])
            {
                dice[i] = roller.roll();
            }
        }
    }

    public int[] getDice()
    {
        return dice;
    }

    public void hold(int... diceToHold)
    {
        Arrays.fill(heldDice, false);

        for (int i : diceToHold)
        {
            heldDice[i-1] = true;
        }
    }



}
