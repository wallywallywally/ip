import java.util.Scanner;
import java.util.Arrays;

// Import tasks
import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

// Import custom exceptions
import exceptions.InvalidDescriptionException;
import exceptions.InvalidCommandException;

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
        // TODO: Type a command to show all commands
        System.out.println("Here are all my valid commands:");
        System.out.println(Arrays.toString(validCommands));
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
     * Check if user command is valid, else throw exception
     */
    private static String[] validCommands = {"bye", "todo", "deadline", "event", "list", "mark", "unmark"};
    public static void checkValidCommand(String command) throws InvalidCommandException {
        if (!Arrays.asList(validCommands).contains(command)) {
            throw new InvalidCommandException();
        }
    }

    // TODO: move these to each class ?
    // TODO: specific exceptions i.e. empty, lacking keyword, etc. + how to solve them
    /**
     * Create tasks.Todo object
     *
     * @param input: tasks.Todo details
     */
    public static Todo createTodo(String input) throws InvalidDescriptionException {
        // Check if input is empty
        if (input.isEmpty()) {
            throw new InvalidDescriptionException();
        }

        return new Todo(input);
    }

    /**
     * Create tasks.Deadline object
     *
     * @param input: tasks.Deadline details
     */
    public static Deadline createDeadline(String input) throws InvalidDescriptionException {
        // Check if input is empty or wrong format
        if (input.isEmpty() | !input.contains("/by")) {
            throw new InvalidDescriptionException();
        }

        int byIndex = input.indexOf("/by");
        int byLength = "/by".length();
        String description = input.substring(0, byIndex).strip();
        String by = input.substring(byIndex + byLength).strip();

        // Check if "by" is empty
        if (by.isEmpty()) {
            throw new InvalidDescriptionException();
        }

        return new Deadline(description, by);
    }

    /**
     * Create tasks.Event object
     *
     * @param input: tasks.Event details
     */
    public static Event createEvent(String input) throws InvalidDescriptionException {
        // Check if input is empty or wrong format
        if (input.isEmpty() | !input.contains("/from") | !input.contains("/to")) {
            throw new InvalidDescriptionException();
        }

        int fromIndex = input.indexOf("/from");
        int toIndex = input.indexOf("/to");
        int fromLength = "/from".length();
        int toLength = "/to".length();
        String description = input.substring(0, fromIndex).strip();
        String from = input.substring(fromIndex + fromLength, toIndex).strip();
        String to = input.substring(toIndex + toLength).strip();

        // Check if "from"/"to" is empty
        if (from.isEmpty() | to.isEmpty()) {
            throw new InvalidDescriptionException();
        }

        return new Event(description, from, to);
    }


    /* MAIN */
    public static void main(String[] args) {
        // Initialise chatbot
        initWally();
        Scanner in = new Scanner(System.in);

        // Read user input continuously
        scan: while (true) {
            String command = in.next().toLowerCase();
            String input = in.nextLine().strip();

            // Check if user command is valid
            try {
                checkValidCommand(command);
            } catch (InvalidCommandException e) {
                System.out.println("Uh oh! I'm not sure what to do :\\");
                continue;       // Break current iteration
            }

            try {
                // Execute task given command
                switch (command) {
                case "todo":
                    // Add tasks.Todo
                    Task todo = createTodo(input);
                    Tasklist.addTask(todo);
                    break;

                case "deadline":
                    // Add tasks.Deadline
                    Task deadline = createDeadline(input);
                    Tasklist.addTask(deadline);
                    break;

                case "event":
                    // Add tasks.Event
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
                }

            } catch (InvalidDescriptionException e) {
                System.out.println("Whoopsies, the description for a task cannot be empty :|");
            }

        }

    }
}
