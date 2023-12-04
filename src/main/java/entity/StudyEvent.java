package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudyEvent extends Event{
    private List<String> todo = new ArrayList<>();

    public StudyEvent(String name, Course course, LocalDateTime startTime, LocalDateTime endTime, Location location,
                      boolean completed, ArrayList<String> todo) {
        super(name, course, startTime, endTime, location, completed);
        this.todo = todo;
    }

    public StudyEvent() {

    }


    public List<String> getTodo() {
        return todo;
    }

    public void addTodo(String input) {
        todo.add(input);
    }
    public void removeTodo(String input) {
        todo.remove(input);
    }
}
