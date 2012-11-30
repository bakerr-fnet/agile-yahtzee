package yahtzee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 29/11/12
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class CategoryTest {

    @Test
    public void score_for_ones_is_sum_of_ones() {
        Category ones = Category.ONES;

        assertEquals(5, ones.calculateScore(1, 1, 1, 1, 1));
        assertEquals(3, ones.calculateScore(1, 1, 2, 2, 1));
        assertEquals(0, ones.calculateScore(2, 3, 4, 5, 5));
    }
    @Test
    public void score_for_chance_is_sum_of_all_dice() {
        Category ones = Category.CHANCE;
        assertEquals(17, ones.calculateScore(3,2,6,5,1));
    }

}
