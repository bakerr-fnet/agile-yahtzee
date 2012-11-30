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

    public String getUserCommand(){
        return display.readInput();
    }

    public void showUserCommandHelp(){
        StringBuilder output = new StringBuilder();
        output.append("enter S and the number next to the category to put the score against it");
        output.append(System.getProperty("line.separator"));
        output.append("enter H and the number of the dice (1 to 5)to hold it");
        output.append(System.getProperty("line.separator"));
        output.append("enter R to roll the dice");
        output.append(System.getProperty("line.separator"));
        output.append("Example: S 9  <--  store score against PAIR");
        output.append(System.getProperty("line.separator"));
        display.show(output.toString());
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
