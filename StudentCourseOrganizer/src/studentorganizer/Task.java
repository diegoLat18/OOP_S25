package studentorganizer;

import java.time.LocalDate;

public class Task { // class for tasks and their dates
    private String title;
    private LocalDate dueDate;

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return title + " (Due: " + dueDate + ")";
    }
}
