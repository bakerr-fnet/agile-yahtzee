package yahtzee;

import org.junit.Assert;
import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test(expected = InvalidStateException.class)
    public void cannot_allocate_same_category_twice() {
        IDieRoller dieRoller = new MockDieRoller(1, 1, 1, 1, 1);
        Game g = new Game(dieRoller);
        g.allocateRoll(Category.CHANCE, 1, 1, 1, 1, 1);
        assertEquals(5, g.getScoreForCategory(Category.CHANCE));
        g.allocateRoll(Category.CHANCE, 1, 1, 1, 1, 1);
    }

    @Test
    public void can_I_play_the_most_basic_game_of_setting_the_dice_roll_to_the_score() {

        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);

        MockDieRoller mockDieRoller = new MockDieRoller(1, 4, 3, 2, 5);
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
    public void can_I_select_the_category_to_put_the_score_against() {

        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);

        MockDieRoller mockDieRoller = new MockDieRoller(1, 4, 3, 2, 5);
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

    @Test
    public void test_is_complete_after_all_categories_have_been_played() {

        Game g = new Game(new DieRoller());
        for (Category c : Category.values()) {
            assertFalse(g.isGameComplete());
            g.allocateRoll(c, 1, 1, 1, 1, 1);
        }
        assertTrue(g.isGameComplete());
    }
}
