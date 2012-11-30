package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class UserConsoleMockDisplay implements UserConsoleDisplay {

    String output;

    public void show(String output) {
        this.output = output;
    }

    public String getDisplay() {
        return output;
    }

}
