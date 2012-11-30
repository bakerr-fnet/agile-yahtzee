package yahtzee;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 29/11/12
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private int[] scoresheet;

    public Game() {
        scoresheet = new int[Category.values().length];
        Arrays.fill(scoresheet, -1);
    }

    public void allocateRoll(Category c, int... dice) {
        //calculate score
        int score = c.calculateScore(dice);

        //store score in scoresheet
        scoresheet[c.ordinal()] = score;
    }

    public int getScoreForCategory(Category c) {
        return scoresheet[c.ordinal()];
    }

    public int[] getScoresheet() {
        return scoresheet;
    }

}
