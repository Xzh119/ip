package samantha.task;
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }


    public String toSaveFormat() {
        return description;
    }
    public static Task fromSaveFormat(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];

        switch (type) {
            case "T":
                return Todo.fromSaveFormat(line);
            case "D":
                return Deadline.fromSaveFormat(line);
            case "E":
                return Event.fromSaveFormat(line);
            default:
                throw new IllegalArgumentException("Invalid task type in file");
        }

    }


    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}