package tasks;


/**
 * Normal task.
 */
public class Todo extends Task {
    // METHODS
    /**
     * Constructor for Todo.
     */
    public Todo (String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
