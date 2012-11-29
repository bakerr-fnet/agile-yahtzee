package yahtzee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 29/11/12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {

    @Test
    public void can_allocate_roll_of_ones_to_category() {
        int expected, actual;
        Game g = new Game();
        g.allocateRoll(Category.ONES, 1, 1, 1, 1, 1);
        expected = 5;
        actual = g.getScore(Category.ONES);
        assertEquals(expected, actual);

        g.allocateRoll(Category.ONES, 1, 2, 2, 2, 1);
        expected = 2;
        actual = g.getScore(Category.ONES);
        assertEquals(expected, actual);

        g.allocateRoll(Category.ONES, 3, 2, 2, 2, 5);
        expected = 0;
        actual = g.getScore(Category.ONES);
        assertEquals(expected, actual);
    }

    @Test
    public void scoresheet_has_fifteen_categories() {
        assertEquals(15, new Game().getScoresheet().length);
    }

}
