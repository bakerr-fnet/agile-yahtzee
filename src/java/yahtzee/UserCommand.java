package yahtzee;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 30/11/12
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public enum UserCommand {

    ROLL {
        String getCommandCode() { return "R"; }
        int[] parse(String input) {return null;}
    },
    HOLD {
        String getCommandCode() { return "H"; }
        int[] parse(String input) {return null;}
    },
    ALLOCATE {
        String getCommandCode() { return "S"; }
        int[] parse(String input) {
            String[] params = input.split(" ");
            if (params.length == 2) {
                try {
                    int result = Integer.parseInt(params[1], 16);
                    if (result >= 1 && result <= 15) return new int[] { result - 1 };
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect parameter entered, pick again: " + params[1]);
                }

            }
            throw new IllegalArgumentException("Incorect number of parameters entered, pick again: " + input);
        }
    };

    static UserCommand selectCommand(String input) {
        for (UserCommand c : UserCommand.values()) {
            if (input.startsWith(c.getCommandCode())) {
                return c;
            }
        }

        return null;
    }
    abstract int[] parse(String input);
    abstract String getCommandCode();

}
