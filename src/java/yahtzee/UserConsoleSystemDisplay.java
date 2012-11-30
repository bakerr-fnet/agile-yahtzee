package yahtzee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public String readInput() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
