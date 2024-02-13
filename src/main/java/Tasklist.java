import java.rmi.NotBoundException;
import java.util.ArrayList;

// Import Task class and subclasses
import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

// Import custom exceptions
// Description exceptions
import exceptions.descriptions.EmptyDescriptionException;
import exceptions.descriptions.IncompleteDescriptionException;
import exceptions.descriptions.WrongFormatDescriptionException;


/**
 * Tasklist class
 * Store and manage tasks.
 */
public class Tasklist {
    // ATTRIBUTES
    private static ArrayList<Task> tasks = new ArrayList<>();

    // METHODS
    /**
     * Create tasks.Todo object
     *
     * @param input: tasks.Todo details
     */
    public static Todo createTodo(String input) throws EmptyDescriptionException {
        // Check if input is empty
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        return new Todo(input);
    }

    /**
     * Create tasks.Deadline object
     *
     * @param input: tasks.Deadline details
     */
    public static Deadline createDeadline(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
        // Check if input is empty or wrong format
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        } else if (!input.contains("/by")) {
            throw new WrongFormatDescriptionException("Deadline");
        }

        int byIndex = input.indexOf("/by");
        int byLength = "/by".length();
        String description = input.substring(0, byIndex).strip();
        String by = input.substring(byIndex + byLength).strip();

        // Check if description/by is empty
        if (description.isEmpty() | by.isEmpty()) {
            throw new IncompleteDescriptionException();
        }

        return new Deadline(description, by);
    }

    /**
     * Create tasks.Event object
     *
     * @param input: tasks.Event details
     */
    public static Event createEvent(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
        // Check if input is empty or wrong format
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        } else if (!input.contains("/from") | !input.contains("/to")) {
            throw new WrongFormatDescriptionException("Event");
        }

        int fromIndex = input.indexOf("/from");
        int toIndex = input.indexOf("/to");
        int fromLength = "/from".length();
        int toLength = "/to".length();
        String description = input.substring(0, fromIndex).strip();
        String from = input.substring(fromIndex + fromLength, toIndex).strip();
        String to = input.substring(toIndex + toLength).strip();

        // Check if description/from/to is empty
        if (description.isEmpty() | from.isEmpty() | to.isEmpty()) {
            throw new IncompleteDescriptionException();
        }

        return new Event(description, from, to);
    }

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
        );
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
            System.out.println("0_0 Oh my, better get to work...");
        } else if (tasks.size() == 0) {
            System.out.println("No tasks! Great job :)");
        }
    }

    /**
     * Mark selected task
     *
     * @param index: Index of task
     */
    public static void markDone(int index) {
        int actualIndex = index - 1;            // Throw NumberFormatException
        Task task = tasks.get(actualIndex);     // Throw ArrayIndexOutOfBoundsException
        task.markDone();
    }

    /**
     * Unmark selected task
     *
     * @param index: Index of task
     */
    public static void unmarkDone(int index) {
        int actualIndex = index - 1;            // Throw NumberFormatException
        Task task = tasks.get(actualIndex);     // Throw ArrayIndexOutOfBoundsException
        task.unmarkDone();
    }

}
