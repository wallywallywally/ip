package tasks;

/**
 * Task abstract class
 * Stores information on task.
 */
public abstract class Task {
    // ATTRIBUTES
    protected String description;
    protected boolean isDone;

    // METHODS
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }
    
    /**
     * Return status and description of task
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Set isDone
     * Mark sets it to true
     * Unmark sets it to false
     */
    public void setDone(boolean state) {
        isDone = state;
    }

}
