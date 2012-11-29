package yahtzee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 29/11/12
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class CategoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void can_allocate_roll_of_ones_to_category() {
        Game g = new Game();
        g.allocateRoll(Category.ONES, 1, 1, 1, 1, 1);
        int expected = 5;
        int actual = g.getScore(Category.ONES);
        assertEquals(expected, actual);
    }

    @Test
    public void scoresheet_has_fifteen_categories() {
        assertEquals(15, new Game().getScoresheet().length);
    }

}
