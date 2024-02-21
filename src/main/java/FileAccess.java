// Import Task class and subclasses
import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

// Read
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// Write
import java.io.FileWriter;
import java.io.IOException;

public class FileAccess {
    private static final String DIVIDER = " | ";
    // 1. load data (read) on start up
    // 1a. if no file, create a file
    // 2. updateData whenever smth is updated
    //
    // format
    // type / marked / description / by OR from / to (changed to |)
    // T / 1 / eat
    // D / 0 / hw / friday
    // E / 0 / rockfest / 12pm / 5pm


    public static void createFile(String filepath) throws IOException {
        File data = new File(filepath);
        if (data.createNewFile()) {
            System.out.println("File created!");
        }
    }

    // placed in a Tasklist method that iniitalises Tasklist
    public static void readFile(String filepath) throws FileNotFoundException {
        File data = new File(filepath);
        Scanner reader = new Scanner(data);
        while (reader.hasNext()) {
            String entry = reader.nextLine();
            String[] details = entry.split(DIVIDER);

            // Format, then createTask and add
            switch(details[0]) {
            case ("T"):
                Task todo = new Todo(details[2]);
                break;
            case ("D"):

                break;
            case ("E"):

                break;
            default:
                // Do nothing
            }
        }
    }

    // 2. updateData
    // line == index
    // add -> append
    // mark -> update
    // delete -> delete line
    private void appendData(String filepath, Task task) throws IOException {
        FileWriter fw = new FileWriter(filepath, true);

        // format data: type / isDone / description / extra
        char type = task.getClass().toString().charAt(0);
        String formattedData = type + DIVIDER + task.getIsDoneInt() + DIVIDER + task.getDescription();
        switch(type) {
        case 'D':
            Deadline deadline = (Deadline) task;
            formattedData += DIVIDER + deadline.getBy();
            break;
        case 'E':
            Event event = (Event) task;
            formattedData += DIVIDER + event.getFrom() + DIVIDER + event.getTo();
            break;
        default:
            // Do nothing
        }

        fw.write(formattedData);
        fw.close();
    }

//    private void update
//    private void delete

}
