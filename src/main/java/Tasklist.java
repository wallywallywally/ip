public class Tasklist {
    // ATTRIBUTES
    private static Task[] tasks = new Task[100];
    private static int taskCount = 0;

    // METHODS
    public static void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount++;
        System.out.println("Nice! A new task has been added:");
        System.out.println(task.toString());
        System.out.println(
            "You now have " + taskCount +
            (taskCount == 1 ? " task" : " tasks")
            + " in the list!");
    }

    public static void viewTasks() {
        System.out.println("Let's take a look at all your tasks...");
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            System.out.println(i + 1 + "." + task.toString());
        }
        if (taskCount > 5) {
            System.out.println("Oh my, better get to work...");
        }
    }

    /**
     * ! EXCEPTION HANDLING
     * done later, should fix this over-engineered code
    */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException error) {
            return false;
        }

        return true;
    }

    public static boolean checkMarkUnmarkDone(String input) {
        String[] words = input.split(" ");

        // ! EXCEPTION HANDLING -> done later
        // Check that it is "mark [int]"
        if (words.length == 2) {
            if (isNumeric(words[1])) {
                int taskIndex = Integer.parseInt(words[1]) - 1;
                if (taskIndex + 1 <= taskCount) {
                    if (words[0].equals("mark")) {
                        Task task = tasks[taskIndex];
                        task.markDone();
                        return true;
                    } else if (words[0].equals("unmark")) {
                        Task task = tasks[taskIndex];
                        task.unmarkDone();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void markDone(int index) {
        Task task = tasks[index];
        task.markDone();
    }

    public static void unmarkDone(int index) {
        Task task = tasks[index];
        task.unmarkDone();
    }

}
