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

    /**
     * Set isDone
     */
    public void setIsDone(boolean) {
        return isDone ==
    }


    /**
     * Turn isDone into a status icon
     */
    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Get description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get isDone
     */
    public int getIsDoneInt() {
        return isDone ? 1 : 0;
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
