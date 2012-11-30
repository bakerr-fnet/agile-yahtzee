package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleYahtzeeApp {

    public static void main(String[] args) {
        Game game = new Game(new DieRoller());
        UserConsole console = new UserConsole(new UserConsoleSystemDisplay());
        console.showScorecard(game.getScoresheet());
        int[] rolledDice = game.getDice();
        console.showDice(rolledDice);
        game.allocateRoll(Category.CHANCE, rolledDice);
        console.showScorecard(game.getScoresheet());
    }

}
