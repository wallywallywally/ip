import java.util.Scanner;

public class Duke {
    // LEVEL-0
    // Initialise chatbot
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

    // Exit chatbot
    public static void exitWally() {
        System.out.println("Womp womp. Goodbye and see you soon!");
    }

    // LEVEL-1: Echo
    public static void echo(String input) {
        System.out.println(input);
    }


    // MAIN
    public static void main(String[] args) {
        // Initialise chatbot
        initWally();
        // Initialise Scanner
        Scanner in = new Scanner(System.in);

        // Run Scanner continuously
        scan: while (true) {
            // Read command and input
            String command = in.next();
            String input = in.nextLine().strip();

            // Mark done
//            boolean breakLoop = Tasklist.checkMarkUnmarkDone(input);
//            if (breakLoop) {
//                continue;
//            }

            switch (command) {
            case "todo":
                // Add Todo
                Task todo = new Todo(input);
                Tasklist.addTask(todo);
                break;

            case "deadline":
                // Add Deadline
                int byIndex = input.indexOf("/by");
                String todoDescription = input.substring(0, byIndex).strip();
                String by = input.substring(byIndex + 4).strip();

                Task deadline = new Deadline(todoDescription, by);
                Tasklist.addTask(deadline);
                break;

            case "event":
                // Add Event
                int fromIndex = input.indexOf("/from");
                int toIndex = input.indexOf("/to");
                String eventDescription = input.substring(0, fromIndex).strip();
                String from = input.substring(fromIndex + 6, toIndex).strip();
                String to = input.substring(toIndex + 4).strip();

                Task event = new Event(eventDescription, from, to);
                Tasklist.addTask(event);
                break;

            case "list":
                // View tasks
                Tasklist.viewTasks();
                break;

            // Newly implement without exception handling yet
            case "mark":
                Tasklist.markDone(Integer.parseInt(input) - 1);
                break;

            case "unmark":
                Tasklist.unmarkDone(Integer.parseInt(input) - 1);
                break;

            case "bye":
                // Exit chatbot
                exitWally();
                break scan;

            default:
                // Echo
                System.out.print("Did not understand: ");
                echo(command + " " + input);
                System.out.println("Please try again!");
            }
        }
    }
}
