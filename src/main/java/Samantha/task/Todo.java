package samantha.task;
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }
    @Override
    public String toSaveFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    public static Todo fromSaveFormat(String line) {
        String[] parts = line.split(" \\| ");
        boolean isDone = parts[1].equals("1");
        Todo task = new Todo(parts[2]);
        if (isDone) task.markAsDone();
        return task;
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
