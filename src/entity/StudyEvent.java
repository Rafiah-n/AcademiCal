package entity;

import java.util.ArrayList;
import java.util.List;

public class StudyEvent extends Event{
    private List<String> todo = new ArrayList<>();


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
