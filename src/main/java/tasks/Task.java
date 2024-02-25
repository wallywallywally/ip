package tasks;

/**
 * Stores general information on a task.
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

    public void setDone(boolean state) {
        isDone = state;
    }


    /**
     * Turn isDone into a status icon.
     */
    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getDescription() {
        return description;
    }

    /**
     * Get isDone as an Integer.
     */
    public int getIsDoneInt() {
        return isDone ? 1 : 0;
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
