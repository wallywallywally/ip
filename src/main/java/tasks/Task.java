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
     * Mark task
     */
    public void markDone() {
        isDone = true;
        System.out.println("Yay, task done!");
        System.out.println(this);
    }

    /**
     * Unmark task
     */
    public void unmarkDone() {
        isDone = false;
        System.out.println("Oh no, task not done...");
        System.out.println(this);
    }
}
