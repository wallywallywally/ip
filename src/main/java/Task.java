// LEVEL-3
public class Task {
    // ATTRIBUTES
    protected String description;
    protected boolean isDone;

    // METHODS
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markDone() {
        isDone = true;
        System.out.println("Yay, task done!");
        System.out.println("[" + getStatusIcon() + "] " + description);
    }

    public void unmarkDone() {
        isDone = false;
        System.out.println("Oh no, task not done...");
        System.out.println("[" + getStatusIcon() + "] " + description);
    }
}
