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
        console.showDice(game.getDice());
        console.showUserCommandHelp();

        //retrieve input
        String commandText = console.getUserCommand();
        UserCommand command = UserCommand.selectCommand(commandText);

        switch (command) {
            case HOLD:
            case ROLL:
                System.out.println("Command not supported, try again");
                break;
            case ALLOCATE:
                Category userSelectedCategory = console.getUserSelectedCategory(command.parse(commandText));
                game.allocateRoll(userSelectedCategory, game.getDice());
                console.showScorecard(game.getScoresheet());
                break;
        }


    }

}
