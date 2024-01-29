import java.util.Scanner;

public class Duke {
    // LEVEL-0
    // Initialise chatbot
    public static void initWally() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String chatbotName = "Wallybot";

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

    // LEVEL-2
    // Initialise task list
    private static final Task[] taskList = new Task[100];
    private static int taskCount = 0;

    public static void addTask(String input) {
        // Handle no input
        if (input.isBlank()) {
            System.out.println("Oops, nothing detected...try again!");
            return;
        }

        Task task = new Task(input);
        taskList[taskCount] = task;
        taskCount++;
        System.out.println("Nice! Added: " + task.description);
    }

    public static void viewTasks() {
        System.out.println("Here are your tasks:");
        for (int i = 0; i < taskCount; i++) {
            Task task = taskList[i];
            System.out.println(
                    i+1 + ".[" + task.getStatusIcon() + "] " + task.description
            );
        }
    }

    // LEVEL-3
    // Probably over-engineered...
    public static boolean isNumeric(String str) {
        try {
            int intTest = Integer.parseInt(str);
        } catch (NumberFormatException error) {
            return false;
        }

        return true;
    }

    public static boolean checkMarkUnmarkDone(String input) {
        String[] words = input.split(" ");

        // Check that it is "mark [int]"
        if (words.length == 2) {
            if (isNumeric(words[1])) {
                int taskIndex = Integer.parseInt(words[1]) - 1;
                if (taskIndex + 1 <= taskCount) {
                    if (words[0].equals("mark")) {
                        Task task = taskList[taskIndex];
                        task.markDone();
                        return true;
                    } else if (words[0].equals("unmark")) {
                        Task task = taskList[taskIndex];
                        task.unmarkDone();
                        return true;
                    }
                }
            }
        }
        return false;
    }



    // MAIN
    public static void main(String[] args) {
        // Initialise chatbot
        initWally();
        // Initialise Scanner
        Scanner in = new Scanner(System.in);

        // Run Scanner continuously
        scan: while (true) {
            // Read input
            String input;
            input = in.nextLine().strip();

            // Mark done
            boolean continueLoop = checkMarkUnmarkDone(input);
            if (continueLoop) {
                continue;
            }

            switch (input) {
            case "bye":
                // Exit chatbot
                exitWally();
                break scan;
            case "list":
                // View tasks
                viewTasks();
                break;
            default:
                // Add task to list
                addTask(input);
            }
        }
    }
}
