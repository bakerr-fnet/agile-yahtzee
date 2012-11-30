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

    @Test
    public void score_for_twos_is_added(){
        Category twos = Category.TWOS;
        assertEquals(0, twos.calculateScore(1, 1, 1, 1, 5));
        assertEquals(2, twos.calculateScore(1, 2, 1, 1, 1));
        assertEquals(4,twos.calculateScore(1,2,4,2,1));
        assertEquals(10, twos.calculateScore(2, 2, 2, 2, 2));
    }

    @Test
    public void score_for_threes_is_added(){
        Category threes = Category.THREES;
        assertEquals(0, threes.calculateScore(1, 1, 1, 1, 5));
        assertEquals(3, threes.calculateScore(1, 2, 1, 3, 1));
        assertEquals(6,threes.calculateScore(1,2,4,3,3));
        assertEquals(15, threes.calculateScore(3,3,3,3,3));
    }

    @Test
    public void score_for_fours_is_added(){
        Category fours = Category.FOURS;
        assertEquals(0, fours.calculateScore(1, 1, 1, 1, 5));
        assertEquals(4, fours.calculateScore(1, 2, 1, 4, 1));
        assertEquals(8,fours.calculateScore(1,2,4,2,4));
        assertEquals(20, fours.calculateScore(4,4,4,4,4));
    }

    @Test
    public void score_for_fives_is_added(){
        Category fives = Category.FIVES;
        assertEquals(0, fives.calculateScore(1, 1, 1, 1, 3));
        assertEquals(5, fives.calculateScore(1, 2, 1, 5, 1));
        assertEquals(10,fives.calculateScore(1,5,5,2,1));
        assertEquals(25, fives.calculateScore(5,5,5,5,5));
    }

    @Test
    public void score_for_sixes_is_added(){
        Category sixes = Category.SIXES;
        assertEquals(0, sixes.calculateScore(1, 1, 1, 1, 5));
        assertEquals(6, sixes.calculateScore(1, 6, 1, 1, 1));
        assertEquals(12,sixes.calculateScore(1,6,4,6,1));
        assertEquals(30, sixes.calculateScore(6,6,6,6,6));
    }

    @Test
    public void score_for_small_straight_is_added(){
        Category smallStraight = Category.SMALL_STRAIGHT;
        assertEquals(0, smallStraight.calculateScore(1, 2, 3, 4, 1));
        assertEquals(15, smallStraight.calculateScore(1, 2, 3, 4, 5));
        assertEquals(15, smallStraight.calculateScore(2, 4, 3, 1, 5));
        assertEquals(0, smallStraight.calculateScore(2,3,4,5,3));
        assertEquals(0,smallStraight.calculateScore(3,4,5,6,6));
        assertEquals(0, smallStraight.calculateScore(6, 6, 6, 6, 6));
    }

    @Test
    public void score_for_large_straight_is_added(){
        Category largeStraight = Category.LARGE_STRAIGHT;
        assertEquals(0, largeStraight.calculateScore(1, 2, 3, 4, 5));
        assertEquals(20, largeStraight.calculateScore(2, 3, 4, 5, 6));
        assertEquals(0, largeStraight.calculateScore(3, 4, 5, 6, 6));
        assertEquals(0, largeStraight.calculateScore(6, 6, 6, 6, 6));
        assertEquals(20, largeStraight.calculateScore(6, 5, 4, 2, 3));
    }

    @Test
    public void score_for_yahtzee(){
        Category yahtzee = Category.YAHTZEE;
        assertEquals(50, yahtzee.calculateScore(1,1,1,1,1));
        assertEquals(50, yahtzee.calculateScore(2,2,2,2,2));
        assertEquals(50, yahtzee.calculateScore(3,3,3,3,3));
        assertEquals(50, yahtzee.calculateScore(4,4,4,4,4));
        assertEquals(50, yahtzee.calculateScore(5,5,5,5,5));
        assertEquals(50, yahtzee.calculateScore(6,6,6,6,6));
        assertEquals(0, yahtzee.calculateScore(1,2,1,1,2));
        assertEquals(0, yahtzee.calculateScore(3,4,5,6,3));
    }
}
