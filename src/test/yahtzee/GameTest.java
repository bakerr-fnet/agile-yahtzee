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
    public void allocate_roll_of_dice_to_ones() {
        Game g = new Game();
        g.allocateRoll(Category.ONES, 1, 1, 6, 1, 1);
        assertEquals(4, g.getScoreForCategory(Category.ONES));
    }

    @Test
    public void scoresheet_has_fifteen_categories() {
        assertEquals(15, new Game().getScoresheet().length);
    }

    @Test
    public void allocate_roll_of_dice_to_chance() {
        Game g = new Game();
        g.allocateRoll(Category.CHANCE, 1, 1, 1, 1, 1);
        assertEquals(5, g.getScoreForCategory(Category.CHANCE));
    }
}
