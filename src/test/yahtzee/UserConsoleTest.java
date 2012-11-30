package yahtzee;

import com.sun.org.apache.xpath.internal.jaxp.JAXPVariableStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
public class UserConsoleTest {

    @Test
    public void can_I_see_an_empty_scoresheet(){
        //need a mock for system.out
        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);
        int[] scorecard = new int[15];
        Arrays.fill(scorecard, -1);
        userConsole.showScorecard(scorecard);
        String expected = "1\tCHANCE|" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void can_I_see_the_dice(){
        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);

        MockDieRoller mockDieRoller = new MockDieRoller(1,4,3,2,5);
        Dice dice = new Dice(mockDieRoller);

        int[] rolledDice = dice.getDice();

        userConsole.showDice(rolledDice);
        String expected = "1 4 3 2 5 " + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void can_I_see_an_empty_scoresheet_with_chance_and_one_pair(){
        //need a mock for system.out
        UserConsoleMockDisplay mockDisplay = new UserConsoleMockDisplay();
        UserConsole userConsole = new UserConsole(mockDisplay);
        int[] scorecard = new int[15];
        Arrays.fill(scorecard, -1);
        userConsole.showScorecard(scorecard);
        String expected = "1\tCHANCE|" + System.getProperty("line.separator") + "9\tPAIR|" + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);
    }
}
