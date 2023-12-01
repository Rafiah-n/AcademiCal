package entity;

import java.time.*;
import java.util.Optional;

public class Event {
    private String name;
    private Course course;
    private OptionalTime optStartTime = new OptionalTime("");
    private LocalDateTime startTime;
    private OptionalTime optEndTime   = new OptionalTime("");
    private LocalDateTime endTime;
    private Location location;
    private boolean completed;

    public Event(String name, Course course, LocalDateTime startTime, LocalDateTime endTime, Location location,
                 boolean completed){
        this.name = name;
        this.course = course;
        this.startTime =startTime;
        this.endTime = endTime;
        this.completed = completed;
    }

    public Event() {

    }

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

    public OptionalTime getOptStartTime() {
        return optStartTime;
    }
    public void setOptStartTime(OptionalTime optStartTime) {
        this.optStartTime = optStartTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime time){
        startTime = time;
    }

    public OptionalTime getOptEndTime() {
        return optEndTime;
    }
    public void setOptEndTime(OptionalTime optEndTime) {
        this.optEndTime = optEndTime;
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

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", optStartTime=" + optStartTime.generateTime() +
                ", startTime=" + startTime +
                ", optEndTime=" + optEndTime.generateTime() +
                ", endTime=" + endTime +
                ", location=" + location +
                ", completed=" + completed +
                '}';
    }
}
