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
        String expected = "CHANCE|" + System.getProperty("line.separator");
        String actual = mockDisplay.getDisplay();
        Assert.assertEquals(expected, actual);
    }
}
