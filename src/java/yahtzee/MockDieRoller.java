package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class MockDieRoller implements IDieRoller {

    private int[] results;
    private short i;

    public MockDieRoller(int... results) {
        this.results = results;
        this.i = 0;
    }

    @Override
    public int roll() {
        return results[i++];
    }
}
