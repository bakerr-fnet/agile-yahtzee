package yahtzee;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class DiceTest {
    Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice(new DieRoller());
    }

    @Test
    public void dice_gives_correct_number_of_dice() {
        assertEquals(Dice.DICE_COUNT, dice.getDice().length);

    }

    @Test
    public void roll_changes_all_the_dice() {
        //store a copy of the original dice, then check that subsequent rolls cause all dice to be changed
        int[] initialDice = dice.getDice().clone();
        boolean[] diceChanged = new boolean[Dice.DICE_COUNT];

        for (int i = 0; i < 600; i++) {
            dice.roll();
            int[] currentDice = dice.getDice();
            for (int d = 0; d < Dice.DICE_COUNT; d++) {
                if (!diceChanged[d] && currentDice[d] != initialDice[d]) {
                    diceChanged[d] = true;
                }
            }
        }

        for (int i = 0; i < Dice.DICE_COUNT; i++) {
            assertTrue(diceChanged[i]);
        }

    }
}
