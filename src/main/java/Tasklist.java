import java.util.ArrayList;

import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

import exceptions.descriptions.EmptyDescriptionException;
import exceptions.descriptions.IncompleteDescriptionException;
import exceptions.descriptions.WrongFormatDescriptionException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 * Store and manage tasks.
 */
public class Tasklist {
    // ARRAYLIST
    private ArrayList<Task> tasks;

    // METHODS
    public Tasklist() {
        tasks = new ArrayList<>();
    }

    /**
     * Create Todo object.
     *
     * @param input: Todo details
     */
    public Todo createTodo(String input) throws EmptyDescriptionException {
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        return new Todo(input);
    }

    /**
     * Create Deadline object.
     *
     * @param input: Deadline details
     */
    public Deadline createDeadline(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
        final String BY = "/by";

        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        } else if (!input.contains(BY)) {
            throw new WrongFormatDescriptionException("Deadline");
        }

        String description = input.substring(0, input.indexOf(BY)).strip();
        String by = input.substring(input.indexOf(BY) + BY.length()).strip();

        if (description.isEmpty() | by.isEmpty()) {
            throw new IncompleteDescriptionException();
        }

        return new Deadline(description, by);
    }

    /**
     * Create Event object.
     *
     * @param input: Event details
     */
    public Event createEvent(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
        final String FROM = "/from";
        final String TO = "/to";

        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        } else if (!input.contains(FROM) | !input.contains(TO)) {
            throw new WrongFormatDescriptionException("Event");
        }

        String description = input.substring(0, input.indexOf(FROM)).strip();
        String from = input.substring(input.indexOf(FROM) + FROM.length(), input.indexOf(TO)).strip();
        String to = input.substring(input.indexOf(TO) + TO.length()).strip();

        if (description.isEmpty() | from.isEmpty() | to.isEmpty()) {
            throw new IncompleteDescriptionException();
        }

        return new Event(description, from, to);
    }

    /**
     * Add a new task.
     */
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Nice! A new task has been added:");
        System.out.println(task);
        int taskCount = tasks.size();
        System.out.println(
            "You now have " + taskCount +
            (taskCount == 1 ? " task" : " tasks")
        );
    }

    /**
     * Delete a task
     *
     * @param index: Index of task
     */
    public void deleteTask(int index) {
        int actualIndex = index - 1;
        Task task = tasks.get(actualIndex);
        tasks.remove(actualIndex);
        System.out.println("Brrrppp...deleting task:");
        System.out.println(task);
        int taskCount = tasks.size();
        System.out.println(
            "You now have " + taskCount +
            (taskCount == 1 ? " task" : " tasks")
        );
    }

    /**
     * View all tasks.
     */
    public void viewTasks() {
        System.out.println("Let's take a look at all your tasks...");
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + 1 + "." + task);
        }
        if (tasks.size() > 5) {
            System.out.println("0_0 Oh my, better get to work...");
        } else if (tasks.isEmpty()) {
            System.out.println("No tasks! Great job :)");
        }
    }

    /**
     * Mark or unmark selected task.
     *
     * @param done: Mark if true, unmark if false
     * @param index: Index of task
     */
    public void markDone(boolean done, int index) {
        int actualIndex = index - 1;
        Task task = tasks.get(actualIndex);
        task.setDone(done);
        System.out.println(done ? "Yay, task done!" : "Oh no, task not done...");
        System.out.println(task);
    }

    /**
     * Show a list of tasks containing the given keyword.
     *
     * @param key: Keyword to search for
     */
    public void findTasks(String key) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(key)) {
                indices.add(tasks.indexOf(task));
            }
        }

        if (!indices.isEmpty()) {
            System.out.println(
                    "I have found " + indices.size() + " matching " +
                    (indices.size() == 1 ? "task" : "tasks")
                    + ":"
            );
            for (int i = 0; i < indices.size() ; i++) {
                System.out.println(i + 1 + "." + tasks.get(indices.get(i)));
            }
        } else {
            System.out.println("There are no matching tasks :O");
        }

    }

    // FILE ACCESS
    /**
     * Add existing tasks from filepath.
     */
    public void addExisting(Task task) {
        tasks.add(task);
    }

    /**
     * Format data for writing into desired filepath.
     *
     * @return Data formatted for writing
     */
    public String formatWriteData() {
        StringBuilder formattedData = new StringBuilder();
        final String DIVIDER = "/";

        for (Task task : tasks) {
            // FORMAT: type / isDone / description / extra
            char type = task.toString().charAt(1);
            String entry = type + DIVIDER + task.getIsDoneInt() + DIVIDER + task.getDescription();
            switch (type) {
            case 'D':
                Deadline deadline = (Deadline) task;
                entry += DIVIDER + deadline.getBy();
                break;
            case 'E':
                Event event = (Event) task;
                entry += DIVIDER + event.getFrom() + DIVIDER + event.getTo();
                break;
            default:
                // Do nothing
            }

            formattedData.append(entry).append(System.lineSeparator());
        }

        return formattedData.toString();
    }



}
