package samantha.task;
public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }

    public static Event fromSaveFormat(String line) {
        String[] parts = line.split(" \\| ");
        boolean isDone = parts[1].equals("1"); //
        Event task = new Event(parts[2], parts[3], parts[4]);
        if (isDone) task.markAsDone();
        return task;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
