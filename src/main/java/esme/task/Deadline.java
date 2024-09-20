package esme.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private String taskType;
    private LocalDate by;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
        this.taskType = "deadline";
    }

    public LocalDate getLocalDate() {
        return this.by;
    }

    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDate() {
        return by.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDate() + ")";
    }
}
