package use_case;

import entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class createEventInputData {

    private Event event;

    public createEventInputData(String name, Course course, LocalDateTime startTime, LocalDateTime endTime,
                                Location location, boolean completed, Resource resource, boolean required) {
        event = new ReadingEvent(name, course, startTime, endTime, location, completed, resource, required);

    }

    public createEventInputData(String name, Course course, LocalDateTime startTime,
                                LocalDateTime endTime, Location location, boolean completed, String type) {
        event = new ClassEvent(name, course, startTime, endTime, location, completed, type);

    }

    public createEventInputData(String name, Course course, LocalDateTime startTime,
                                LocalDateTime endTime, Location location, boolean completed, String type,
                                int percentage, boolean required, LocalDateTime lateDueDate) {
        event = new AssignmentEvent(name, course, startTime, endTime, location, completed, type, percentage,
                required, lateDueDate);

    }

    public createEventInputData(String name, Course course, LocalDateTime startTime, LocalDateTime endTime,
                                Location location, boolean completed, ArrayList<String> todo) {
        event = new StudyEvent(name, course, startTime, endTime, location, completed, todo);

    }

    public Event getEvent() {
        return event;
    }
}
