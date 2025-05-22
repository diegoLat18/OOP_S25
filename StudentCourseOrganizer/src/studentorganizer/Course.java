package studentorganizer;

import java.util.ArrayList;

public class Course { // this class is for student s to add their courses
    private String name;
    private ArrayList<Task> tasks;

    public Course(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTaskByTitle(String title) {
        tasks.removeIf(t -> t.getTitle().equals(title));
    }

}
