package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class UserConsoleSystemDisplay implements UserConsoleDisplay {

    public void show(String output) {
        System.out.print(output);
    }

}
