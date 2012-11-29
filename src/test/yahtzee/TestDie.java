package yahtzee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class TestDie {

    Die die;
    @Before
    public void setUp() throws Exception {
        die = new Die();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void all_dice_values_are_reachable(){

        boolean[] numbers = new boolean[6];
        int total = 0;
        for(int i = 0; i < 600 && total < 21; i++)
        {
            die.roll();
            int value = die.getValue();
            if (!numbers[value-1])
            {
                numbers[value-1] = true;
                total += value;
            }
        }

        assertEquals(21, total);

    }

    @Test
    public void ensure_dice_values_are_not_out_of_range()
    {
        for (int i = 0; i < 600; i++)
        {
            die.roll();
            assertTrue(die.getValue() > 0 && die.getValue() < 7);
        }
    }

    public void ensure_dice_comparison_works()
    {
        assertFalse(new Die().equals(new Object()));
        assertFalse(new Die(1).equals(new Die(2)));
        assertTrue(new Die(1).equals(new Die(1)));
    }

}
