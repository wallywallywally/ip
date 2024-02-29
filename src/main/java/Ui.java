import java.util.Scanner;

import exceptions.WallybotException;


/**
 * Deals with interactions with the user.
 */
public class Ui {
    // ATTRIBUTES
    public static final String TEXTDIVIDER = "- - - - - - - - - - - - -";
    private Scanner in;

    // METHODS
    public Ui() {
        in = new Scanner(System.in);
        showWelcome();
    }

    public void showWelcome() {
        final String LOGO =
                " __       __          __ __          __                  __     \n" +
                        "|  \\  _  |  \\        |  \\  \\        |  \\                |  \\    \n" +
                        "| ▓▓ / \\ | ▓▓ ______ | ▓▓ ▓▓__    __| ▓▓____   ______  _| ▓▓_   \n" +
                        "| ▓▓/  ▓\\| ▓▓|      \\| ▓▓ ▓▓  \\  |  \\ ▓▓    \\ /      \\|   ▓▓ \\  \n" +
                        "| ▓▓  ▓▓▓\\ ▓▓ \\▓▓▓▓▓▓\\ ▓▓ ▓▓ ▓▓  | ▓▓ ▓▓▓▓▓▓▓\\  ▓▓▓▓▓▓\\\\▓▓▓▓▓▓  \n" +
                        "| ▓▓ ▓▓\\▓▓\\▓▓/      ▓▓ ▓▓ ▓▓ ▓▓  | ▓▓ ▓▓  | ▓▓ ▓▓  | ▓▓ | ▓▓ __ \n" +
                        "| ▓▓▓▓  \\▓▓▓▓  ▓▓▓▓▓▓▓ ▓▓ ▓▓ ▓▓__/ ▓▓ ▓▓__/ ▓▓ ▓▓__/ ▓▓ | ▓▓|  \\\n" +
                        "| ▓▓▓    \\▓▓▓\\▓▓    ▓▓ ▓▓ ▓▓\\▓▓    ▓▓ ▓▓    ▓▓\\▓▓    ▓▓  \\▓▓  ▓▓\n" +
                        " \\▓▓      \\▓▓ \\▓▓▓▓▓▓▓\\▓▓\\▓▓_\\▓▓▓▓▓▓▓\\▓▓▓▓▓▓▓  \\▓▓▓▓▓▓    \\▓▓▓▓ \n" +
                        "                           |  \\__| ▓▓                           \n" +
                        "                            \\▓▓    ▓▓                           \n" +
                        "                             \\▓▓▓▓▓▓                            \n"
                ;
        final String CHATBOTNAME = "Wallybot";

        System.out.println(LOGO);
        System.out.println("Beep boop. Hello! I'm " + CHATBOTNAME + "! :P");
        System.out.println("What can I do for you today?");
        System.out.println(TEXTDIVIDER);
    }

    public String[] processInput() throws WallybotException {
        String command = in.next().toLowerCase();
        String input = in.nextLine().strip();

        return new String[]{command, input};
    }

    public void showError(String error) {
        System.out.println(error);
    }

    public void showLine() {
        System.out.println(TEXTDIVIDER);
    }
}
