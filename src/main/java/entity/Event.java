package entity;

import java.time.*;

public abstract class Event {
    private String name;
    private Course course;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Location location;
    private Boolean completed;

    public String getName() {
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course c){
        course = c;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime time){
        startTime = time;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime time){
        endTime = time;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location loc){
        location = loc;
    }

    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean compl){
        completed = compl;
    }
}