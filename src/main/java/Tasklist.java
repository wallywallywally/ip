/**
 * Tasklist class
 * Store and manage tasks.
 */
public class Tasklist {
    // ATTRIBUTES
    private static Task[] tasks = new Task[100];
    private static int taskCount = 0;

    // METHODS

    /**
     * Add a new task
     */
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

    /**
     * View all tasks
     */
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
     * Mark selected task
     *
     * @param index: Index of task
     */
    public static void markDone(int index) {
        int actualIndex = index - 1;
        Task task = tasks[actualIndex];
        task.markDone();
    }

    /**
     * Unmark selected task
     *
     * @param index: Index of task
     */
    public static void unmarkDone(int index) {
        int actualIndex = index - 1;
        Task task = tasks[actualIndex];
        task.unmarkDone();
    }

}
