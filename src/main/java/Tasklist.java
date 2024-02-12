import tasks.Task;

import java.util.ArrayList;

/**
 * Tasklist class
 * Store and manage tasks.
 */
public class Tasklist {
    // ATTRIBUTES
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    // METHODS
    /**
     * Add a new task
     */
    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println("Nice! A new task has been added:");
        System.out.println(task.toString());
        int taskCount = tasks.size();
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
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + 1 + "." + task.toString());
        }
        if (tasks.size() > 5) {
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
        Task task = tasks.get(actualIndex);
        task.markDone();
    }

    /**
     * Unmark selected task
     *
     * @param index: Index of task
     */
    public static void unmarkDone(int index) {
        int actualIndex = index - 1;
        Task task = tasks.get(actualIndex);
        task.unmarkDone();
    }

}
