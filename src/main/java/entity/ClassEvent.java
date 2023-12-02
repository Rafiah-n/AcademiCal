package main.java.entity;

import java.time.LocalDateTime;

public class ClassEvent extends Event{

    private String type;

    public ClassEvent(String name, Course course, LocalDateTime startTime, LocalDateTime endTime,
                      Location location, boolean completed, String type) {
        super(name, course, startTime, endTime, location, completed);
        this.type = type;
    }

    public String getType(){
        return type;
    }
    public void setType(String t){
        type = t;
    }
}
