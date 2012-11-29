package yahtzee;

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
    }

    public void allocateRoll(Category c, int... dice) {
        //calculate score


        //store score in scoresheet
    }

    public int getScore(Category c) {
        return scoresheet[c.ordinal()];
    }

    public int[] getScoresheet() {
        return scoresheet;
    }

}
