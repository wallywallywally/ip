import java.util.Scanner;
import java.util.Arrays;

// Import Task class
import tasks.Task;

// Import custom exceptions
import exceptions.InvalidCommandException;
// Description exceptions
import exceptions.descriptions.EmptyDescriptionException;
import exceptions.descriptions.WrongFormatDescriptionException;
import exceptions.descriptions.IncompleteDescriptionException;


/**
 * Wallybot is a personal assistant chatbot.
 * It keeps track of your tasks and allows you to manage them.
 */
public class Wallybot {
    // Divider to format text for better user readability
    private static final String DIVIDER = "- - - - - - - - - - - - -";

    /**
     * Initialise chatbot
     */
    public static void initWally() {
        String logo =
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
        String chatbotName = "Wallybot";

        System.out.println(logo);
        System.out.println("Beep boop. Hello! I'm " + chatbotName + "! :P");
        System.out.println("What can I do for you today?");
        System.out.println(DIVIDER);
    }

    /**
     * Exit Wallybot
     */
    public static void exitWally() {
        System.out.println("Productive day today! :D Shutting down...");
    }

    /**
     * Echo user input
     */
    public static void echo(String input) {
        System.out.println(input);
    }


    /*  MAIN  */
    public static void main(String[] args) {
        // Initialise chatbot
        initWally();
        Scanner in = new Scanner(System.in);

        // Read user input continuously
        scan: while (true) {
            String command = in.next().toLowerCase();
            String input = in.nextLine().strip();

            try {
                // Execute task given command
                switch (command) {
                case "todo":
                    // Add tasks.Todo
                    Task todo = Tasklist.createTodo(input);
                    Tasklist.addTask(todo);
                    break;

                case "deadline":
                    // Add tasks.Deadline
                    Task deadline = Tasklist.createDeadline(input);
                    Tasklist.addTask(deadline);
                    break;

                case "event":
                    // Add tasks.Event
                    Task event = Tasklist.createEvent(input);
                    Tasklist.addTask(event);
                    break;

                case "delete":
                    // Delete a task
                    Tasklist.deleteTask(Integer.parseInt(input));
                    break;

                case "list":
                    // View all tasks
                    Tasklist.viewTasks();
                    break;

                case "mark":
                    // Mark task as completed
                    Tasklist.markDone(Integer.parseInt(input));
                    break;

                case "unmark":
                    // Unmark completed task
                    Tasklist.unmarkDone(Integer.parseInt(input));
                    break;

                case "bye":
                    // Exit chatbot
                    exitWally();
                    break scan;

                default:
                    // Invalid command
                    throw new InvalidCommandException();

                }

            // Handle invalid command
            } catch (InvalidCommandException e) {
                // Show valid commands
                System.out.println("Need some help? Here are all my valid commands:");
                String[] commands = {"bye", "todo", "deadline", "event", "list", "mark", "unmark", "delete"};
                System.out.println(Arrays.toString(commands));

            // Handle description exceptions
            } catch (EmptyDescriptionException e) {
                System.out.println("Whoopsies, the description for a task cannot be empty :|");

            } catch (WrongFormatDescriptionException e) {
                System.out.println("Hmm...seems that your description is in the wrong format :O");
                String type = e.getType();
                if (type.equals("Deadline")) {
                    System.out.println("A Deadline needs '/by'");
                } else if (type.equals("Event")) {
                    System.out.println("An Event needs '/from' and '/to'");
                }

            } catch (IncompleteDescriptionException e) {
                System.out.println("Oops, the description is incomplete :O");

            // Handle mark/unmark exceptions
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Oopsies, that number does not correspond to a task in your list :O");

            } catch (NumberFormatException e) {
                System.out.println("Shucks...that's not a number :O");
            }

            // Format text using divider
            System.out.println(DIVIDER);
        }

    }
}
