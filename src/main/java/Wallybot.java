import java.util.Scanner;

/**
 * Wallybot is a personal assistant chatbot.
 * It keeps track of your tasks and allows you to manage them.
 */
public class Wallybot {
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
        System.out.println("Beep boop. Hello! I'm " + chatbotName + "!");
        System.out.println("What can I do for you today?");

    }

    /**
     * Exit Wallybot
     */
    public static void exitWally() {
        System.out.println("Productive day today! Shutting down...");
    }

    /**
     * Echo user input
     */
    public static void echo(String input) {
        System.out.println(input);
    }

    /**
     * Create Deadline object
     *
     * @param input: Deadline details
     */
    public static Deadline createDeadline(String input) {
        int byIndex = input.indexOf("/by");
        int byLength = "/by".length();

        String todoDescription = input.substring(0, byIndex).strip();
        String by = input.substring(byIndex + byLength).strip();

        return new Deadline(todoDescription, by);
    }

    /**
     * Create Event object
     *
     * @param input: Event details
     */
    public static Event createEvent(String input) {
        int fromIndex = input.indexOf("/from");
        int toIndex = input.indexOf("/to");
        int fromLength = "/from".length();
        int toLength = "/to".length();

        String eventDescription = input.substring(0, fromIndex).strip();
        String from = input.substring(fromIndex + fromLength, toIndex).strip();
        String to = input.substring(toIndex + toLength).strip();

        return new Event(eventDescription, from, to);
    }

    public static void main(String[] args) {
        // Initialise chatbot
        initWally();
        Scanner in = new Scanner(System.in);

        // Read user input continuously
        scan: while (true) {
            String command = in.next();
            String input = in.nextLine().strip();

            // Execute task given command
            switch (command) {
            case "todo":
                // Add Todo
                Task todo = new Todo(input);
                Tasklist.addTask(todo);
                break;

            case "deadline":
                // Add Deadline
                Task deadline = createDeadline(input);
                Tasklist.addTask(deadline);
                break;

            case "event":
                // Add Event
                Task event = createEvent(input);
                Tasklist.addTask(event);
                break;

            case "list":
                // View all tasks
                Tasklist.viewTasks();
                break;

            // TODO: exception handling
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
                // Echo input when no appropriate command is given
                System.out.print("Did not understand: ");
                echo(command + " " + input);
                System.out.println("Please try again!");
            }
        }
    }
}
