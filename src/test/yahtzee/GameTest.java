package yahtzee;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 29/11/12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {

    @Test
    public void allocate_roll_of_dice_to_ones() {
        IDieRoller dieRoller = new MockDieRoller(1, 1, 6, 1, 1);
        Game g = new Game(dieRoller);
        g.allocateRoll(Category.ONES, 1, 1, 6, 1, 1);
        assertEquals(4, g.getScoreForCategory(Category.ONES));
    }

    @Test
    public void scoresheet_has_fifteen_categories() {
        assertEquals(15, new Game(new MockDieRoller(1, 1, 1, 1, 1)).getScoresheet().length);
    }

    @Test
    public void allocate_roll_of_dice_to_chance() {
        IDieRoller dieRoller = new MockDieRoller(1, 1, 1, 1, 1);
        Game g = new Game(dieRoller);
        g.allocateRoll(Category.CHANCE, 1, 1, 1, 1, 1);
        assertEquals(5, g.getScoreForCategory(Category.CHANCE));
    }

    @Test
    public void can_I_play_the_most_basic_game_of_setting_the_dice_roll_to_the_score(){

        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);

        MockDieRoller mockDieRoller = new MockDieRoller(1,4,3,2,5);
        Game g = new Game(mockDieRoller);

        int[] scorecard = g.getScoresheet();
        userConsole.showScorecard(scorecard);
        String expected = "1\tCHANCE|" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

        int[] rolledDice = g.getDice();

        userConsole.showDice(rolledDice);
        expected = "1 4 3 2 5 " + System.getProperty("line.separator");
        actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

        g.allocateRoll(Category.CHANCE, rolledDice);

        scorecard = g.getScoresheet();
        userConsole.showScorecard(scorecard);

        expected = "1\tCHANCE|15" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void can_I_select_the_category_to_put_the_score_against(){

        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);

        MockDieRoller mockDieRoller = new MockDieRoller(1,4,3,2,5);
        Game g = new Game(mockDieRoller);

        int[] scorecard = g.getScoresheet();
        userConsole.showScorecard(scorecard);
        String expected = "1\tCHANCE|" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

        int[] rolledDice = g.getDice();

        userConsole.showDice(rolledDice);
        expected = "1 4 3 2 5 " + System.getProperty("line.separator");
        actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

        userConsole.showUserCommandHelp();

        //TODO: mock input
        String commandText = userConsole.getUserCommand();
        expected = "S 9";
        actual = commandText;
        Assert.assertEquals(expected, actual);

        UserCommand command = UserCommand.selectCommand(commandText);
        Category userSelectedCategory = userConsole.getUserSelectedCategory(command.parse(commandText));
        expected = "1 4 3 2 5 " + System.getProperty("line.separator");
        actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

        g.allocateRoll(userSelectedCategory, rolledDice);

        scorecard = g.getScoresheet();
        userConsole.showScorecard(scorecard);

        expected = "1\tCHANCE|15" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);

    }
}
