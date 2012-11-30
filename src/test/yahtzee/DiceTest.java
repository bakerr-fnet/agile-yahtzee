package yahtzee;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class DiceTest {


    @Test
    public void dice_gives_correct_number_of_dice() {

        assertEquals(5, new Dice(new DieRoller()).getDice().length);
    }

    @Test
    public void roll_changes_all_the_dice() {

        MockDieRoller mockDieRoller = new MockDieRoller(1,1,1,1,1,2,2,2,2,2);


        //store a copy of the original dice, then check that subsequent rolls cause all dice to be changed
        Dice dice = new Dice(mockDieRoller);

        //assert all 1s
        int[] diceNumbers = dice.getDice();

        assertEquals(1, diceNumbers[0]);
        assertEquals(1, diceNumbers[1]);
        assertEquals(1, diceNumbers[2]);
        assertEquals(1, diceNumbers[3]);
        assertEquals(1, diceNumbers[4]);
        //roll
        dice.roll();
        //assert all 2s
        assertEquals(2, diceNumbers[0]);
        assertEquals(2, diceNumbers[1]);
        assertEquals(2, diceNumbers[2]);
        assertEquals(2, diceNumbers[3]);
        assertEquals(2, diceNumbers[4]);

    }

    @Test
    public void can_hold_dice_between_rolls()
    {
        MockDieRoller mock = new MockDieRoller(new int[]{1,1,1,1,1,2,2,2});
        Dice dice = new Dice(mock);

        //assert all dice are 1
        int[] diceNumbers = dice.getDice();

        assertEquals(1, diceNumbers[0]);
        assertEquals(1, diceNumbers[1]);
        assertEquals(1, diceNumbers[2]);
        assertEquals(1, diceNumbers[3]);
        assertEquals(1, diceNumbers[4]);

        dice.hold(2,4);

        dice.roll();

        assertEquals(2, diceNumbers[0]);
        assertEquals(1, diceNumbers[1]);
        assertEquals(2, diceNumbers[2]);
        assertEquals(1, diceNumbers[3]);
        assertEquals(2, diceNumbers[4]);

    }

    @Test
    public void new_hold_overrides_previous_hold()
    {
        MockDieRoller mock = new MockDieRoller(new int[]{1,1,1,1,1,2,2,2});
        Dice dice = new Dice(mock);

        //assert all dice are 1
        int[] diceNumbers = dice.getDice();

        assertEquals(1, diceNumbers[0]);
        assertEquals(1, diceNumbers[1]);
        assertEquals(1, diceNumbers[2]);
        assertEquals(1, diceNumbers[3]);
        assertEquals(1, diceNumbers[4]);

        dice.hold(2,4);
        dice.hold(1,3);
        dice.roll();
        assertEquals(1, diceNumbers[0]);
        assertEquals(2, diceNumbers[1]);
        assertEquals(1, diceNumbers[2]);
        assertEquals(2, diceNumbers[3]);
        assertEquals(2, diceNumbers[4]);
    }
}
