package use_case.update_event;

import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventInputData {
    private final Event event;
    private final String newName;
    private final Course newCourse;
    private final LocalDateTime newStartTime;
    private final LocalDateTime newEndTime;
    private final Location newLocation;
    private final Boolean newCompleted;

    // Additional properties for specific event types
    private final String newAssignmentType;
    private final Integer newAssignmentPercentage;
    private final Boolean newAssignmentRequired;
    private final LocalDateTime newAssignmentLateDueDate;
    private final List<Double> newAssignmentPercentageReduction;

    private final String newClassType;

    private final Resource newReadingResource;
    private final Boolean newReadingRequired;
    private final List<Integer> newReadingPages;

    private final List<String> newStudyTodo;

    // Constructors
    public UpdateEventInputData(Event event, String newName, Course newCourse, LocalDateTime newStartTime,
                                LocalDateTime newEndTime, Location newLocation, Boolean newCompleted,
                                String newAssignmentType, Integer newAssignmentPercentage,
                                Boolean newAssignmentRequired, LocalDateTime newAssignmentLateDueDate,
                                List<Double> newAssignmentPercentageReduction, String newClassType,
                                Resource newReadingResource, Boolean newReadingRequired,
                                List<Integer> newReadingPages, List<String> newStudyTodo) {
        this.event = event;
        this.newName = newName;
        this.newCourse = newCourse;
        this.newStartTime = newStartTime;
        this.newEndTime = newEndTime;
        this.newLocation = newLocation;
        this.newCompleted = newCompleted;
        this.newAssignmentType = newAssignmentType;
        this.newAssignmentPercentage = newAssignmentPercentage;
        this.newAssignmentRequired = newAssignmentRequired;
        this.newAssignmentLateDueDate = newAssignmentLateDueDate;
        this.newAssignmentPercentageReduction = newAssignmentPercentageReduction;
        this.newClassType = newClassType;
        this.newReadingResource = newReadingResource;
        this.newReadingRequired = newReadingRequired;
        this.newReadingPages = newReadingPages;
        this.newStudyTodo = newStudyTodo;
    }

    // Getters
    public Event getEvent() {
        return event;
    }

    public String getNewName() {
        return newName;
    }

    public Course getNewCourse() {
        return newCourse;
    }

    public LocalDateTime getNewStartTime() {
        return newStartTime;
    }

    public LocalDateTime getNewEndTime() {
        return newEndTime;
    }

    public Location getNewLocation() {
        return newLocation;
    }

    public Boolean getNewCompleted() {
        return newCompleted;
    }

    public String getNewAssignmentType() {
        return newAssignmentType;
    }

    public Integer getNewAssignmentPercentage() {
        return newAssignmentPercentage;
    }

    public Boolean getNewAssignmentRequired() {
        return newAssignmentRequired;
    }

    public LocalDateTime getNewAssignmentLateDueDate() {
        return newAssignmentLateDueDate;
    }

    public List<Double> getNewAssignmentPercentageReduction() {
        return newAssignmentPercentageReduction;
    }

    public String getNewClassType() {
        return newClassType;
    }

    public Resource getNewReadingResource() {
        return newReadingResource;
    }

    public Boolean getNewReadingRequired() {
        return newReadingRequired;
    }

    public List<Integer> getNewReadingPages() {
        return newReadingPages;
    }

    public List<String> getNewStudyTodo() {
        return newStudyTodo;
    }

    // Additional setters if needed
}
