package yahtzee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DieRollerTest {

    DieRoller die;
    @Before
    public void setUp() throws Exception {
        die = new DieRoller();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void all_dice_values_are_reachable(){

        boolean[] dieValue = new boolean[6];
        for(int i = 0; i < 600; i++)
        {
            int value = die.roll();
            if (!dieValue[value-1])
            {
                dieValue[value-1] = true;
            }
        }

        //test all dice values are reachable
        assertTrue(dieValue[0]);//1
        assertTrue(dieValue[1]);//2
        assertTrue(dieValue[2]);//3
        assertTrue(dieValue[3]);//4
        assertTrue(dieValue[4]);//5
        assertTrue(dieValue[5]);//6
    }

    @Test
    public void ensure_dice_values_are_not_out_of_range()
    {
        for (int i = 0; i < 600; i++)
        {
            int value = die.roll();
            assertTrue(value >= 1 && value <= 6);
        }
    }

}
