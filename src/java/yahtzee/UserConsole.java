package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class UserConsole {

    UserConsoleDisplay display;

    public UserConsole(UserConsoleDisplay display) {
        this.display = display;
    }

    public void showScorecard(int[] scorecard) {
        StringBuilder output = new StringBuilder();

        output.append(Category.CHANCE).append("|");

        int score = scorecard[Category.CHANCE.ordinal()];
        if (score != -1) output.append(score);
        output.append(System.getProperty("line.separator"));

        /*
        for (Category c : Category.values()) {
            output.append(c).append("|").append(scorecard[c.ordinal()]);
        }*/

        display.show(output.toString());
    }

    public void showDice(int[] di){
        StringBuilder output = new StringBuilder();
        for (int dice:di){
            output.append(dice);
            output.append(" ");
        }
        output.append(System.getProperty("line.separator"));
        display.show(output.toString());
    }

}
