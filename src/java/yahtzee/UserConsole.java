package yahtzee;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class UserConsole {

    public static String HELP_TEXT = "enter S and the number next to the category to put the score against it\n" +
            "enter H and the number of the dice (1 to 5)to hold it\n" +
            "enter R to roll the dice\n" +
            "Example: S 9  <--  store score against PAIR\n" +
            ">";

    UserConsoleDisplay display;

    public UserConsole(UserConsoleDisplay display) {
        this.display = display;
    }

    public String getUserCommand(){
        try {
            return display.readInput();
        }
        catch (IOException e) {
            System.err.println("Unable to read user input, please try again");
            return "";
        }
    }

    public void showUserCommandHelp(){
        display.show(HELP_TEXT);
    }
    public void showScorecard(int[] scorecard) {
        StringBuilder output = new StringBuilder();

        for (Category c : Category.values()) {
            switch(c){
                case CHANCE :
                case PAIR :
                    output.append(Integer.toHexString(c.ordinal() + 1));
                    output.append("\t");
                    output.append(c);
                    output.append("|");
                    int score = scorecard[c.ordinal()];
                    if (score != -1) output.append(score);
                    output.append(System.getProperty("line.separator"));
                    break;
                default:
            }
        }

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

    public Category getUserSelectedCategory(int[] category) {
        return Category.values()[category[0]];
    }

}
