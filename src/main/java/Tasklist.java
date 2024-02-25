import java.util.ArrayList;

import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

import exceptions.descriptions.EmptyDescriptionException;
import exceptions.descriptions.IncompleteDescriptionException;
import exceptions.descriptions.WrongFormatDescriptionException;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Store and manage tasks.
 */
public class Tasklist {
    // TASKS ARRAYLIST
    private static ArrayList<Task> tasks = new ArrayList<>();

    // METHODS
    /**
     * Create tasks.Todo object.
     *
     * @param input: tasks.Todo details
     */
    public static Todo createTodo(String input) throws EmptyDescriptionException {
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        return new Todo(input);
    }

    /**
     * Create tasks.Deadline object.
     *
     * @param input: tasks.Deadline details
     */
    public static Deadline createDeadline(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
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
     * Create tasks.Event object.
     *
     * @param input: tasks.Event details
     */
    public static Event createEvent(String input) throws EmptyDescriptionException, WrongFormatDescriptionException, IncompleteDescriptionException {
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
    public static void addTask(Task task) throws IOException {
        tasks.add(task);
        System.out.println("Nice! A new task has been added:");
        System.out.println(task);
        int taskCount = tasks.size();
        System.out.println(
            "You now have " + taskCount +
            (taskCount == 1 ? " task" : " tasks")
        );

        writeFile();
    }

    /**
     * Delete a task
     *
     * @param index: Index of task
     */
    public static void deleteTask(int index) throws IOException {
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

        writeFile();
    }

    /**
     * View all tasks.
     */
    public static void viewTasks() {
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
     * Mark selected task.
     *
     * @param index: Index of task
     */
    public static void markDone(int index) throws IOException {
        int actualIndex = index - 1;
        Task task = tasks.get(actualIndex);
        task.setDone(true);
        System.out.println("Yay, task done!");
        System.out.println(task);

        writeFile();
    }

    /**
     * Unmark selected task.
     *
     * @param index: Index of task
     */
    public static void unmarkDone(int index) throws IOException {
        int actualIndex = index - 1;
        Task task = tasks.get(actualIndex);
        task.setDone(false);
        System.out.println("Oh no, task not done...");
        System.out.println(task);

        writeFile();
    }

    // FILE ACCESS
    private static final String DIVIDER = "/";
    private static final String FILEPATH = Paths.get(System.getProperty("user.home"), "Documents", "wallybot_data.txt").toString();

    /**
     * Read data from specified filepath, otherwise create an empty file there.
     */
    public static void initTasklist() {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            createFile();
        }

    }

    /**
     * Create file for storing data at specified filepath.
     */
    private static void createFile() {
        File data = new File(FILEPATH);
        try {
            if (data.createNewFile()) {
                System.out.println("File created for storing my data :))");
            }

        } catch (IOException e) {
            System.out.println("Something went wrong...my data cannot be stored >:(");
        }
    }

    /**
     * Read data from specified filepath.
     */
    private static void readFile() throws FileNotFoundException {
        File data = new File(FILEPATH);
        Scanner reader = new Scanner(data);

        // Process each line
        while (reader.hasNext()) {
            String entry = reader.nextLine();
            String[] details = entry.split(DIVIDER);

            // Format and create task
            Task task = null;
            switch (details[0]) {
            case ("T"):
                task = new Todo(details[2]);
                break;
            case ("D"):
                task = new Deadline(details[2], details[3]);
                break;
            case ("E"):
                task = new Event(details[2], details[3], details[4]);
                break;
            default:
                // Do nothing
            }

            if (task != null) {
                task.setDone(details[1].equals("1"));
                tasks.add(task);
            }
        }
    }

    /**
     * Write data into specified file.
     */
    private static void writeFile() throws IOException {
        StringBuilder formattedData = new StringBuilder();
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

        FileWriter writer = new FileWriter(FILEPATH);
        writer.write(formattedData.toString());
        writer.close();
    }

}
