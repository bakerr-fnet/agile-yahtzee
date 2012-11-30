package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:09
 * To change this template use File | Settings | File Templates.
 */
public class Dice {

    private IDieRoller roller;
    private int[] dice;

    public final static int DICE_COUNT = 5;

    public Dice (IDieRoller roller)
    {
        this.roller = roller;
        dice = new int[]{ 1,1,1,1,1 };
        roll();
    }

    public void roll()
    {
        for (int i=0;i<DICE_COUNT;i++)
        {
            dice[i] = roller.roll();
        }
    }

    public int[] getDice()
    {
        return dice;
    }


}
