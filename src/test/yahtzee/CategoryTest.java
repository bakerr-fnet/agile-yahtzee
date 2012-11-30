package yahtzee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void score_for_pair_is_highest(){
        Category pairs = Category.PAIR;
        assertEquals(12,pairs.calculateScore(2,4,3,6,6));
        assertEquals(12,pairs.calculateScore(2,3,3,6,6));
        assertEquals(0,pairs.calculateScore(2,4,3,1,5));
        assertEquals(12,pairs.calculateScore(2,4,6,6,6));
    }

    @Test
    public void score_for_two_pair_is_added(){
        Category twoPairs = Category.TWO_PAIRS;
        assertEquals(0, twoPairs.calculateScore(2, 4, 3, 6, 6));
        assertEquals(18, twoPairs.calculateScore(2, 3, 3, 6, 6));
        assertEquals(0,twoPairs.calculateScore(2,4,3,1,5));
        assertEquals(8, twoPairs.calculateScore(2, 2, 2, 2, 6));
    }

    @Test
    public void score_for_three_of_a_kind_is_added(){
        Category threeOfAKind = Category.THREE_OF_A_KIND;
        assertEquals(18, threeOfAKind.calculateScore(2, 4, 6, 6, 6));
        assertEquals(0, threeOfAKind.calculateScore(2, 3, 3, 6, 6));
        assertEquals(18,threeOfAKind.calculateScore(6,6,6,6,6));
    }

    @Test
    public void score_for_four_of_a_kind_is_added(){
        Category fourOfAKind = Category.FOUR_OF_A_KIND;
        assertEquals(4, fourOfAKind.calculateScore(1,1,1,1,5));
        assertEquals(4, fourOfAKind.calculateScore(1,1,1,1,1));
        assertEquals(4,fourOfAKind.calculateScore(1,1,4,1,1));
        assertEquals(0, fourOfAKind.calculateScore(2, 2, 2, 6, 6));
    }

}
