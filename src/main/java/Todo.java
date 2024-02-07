/**
 * Todo class
 * Normal task.
 */
public class Todo extends Task {
    // METHODS
    public Todo (String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
