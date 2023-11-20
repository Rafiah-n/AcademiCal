package use_case.update_event;
import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventInputData {
    // private final Event event;
    private String newName;
    private Course newCourse;
    private LocalDateTime newStartTime;
    private LocalDateTime newEndTime;
    private Location newLocation;
    private Boolean newCompleted;

    // Additional properties for specific event types

    // Assignment Event
    private String newAssignmentType;
    private Integer newAssignmentPercentage;
    private Boolean newAssignmentRequired;
    private LocalDateTime newAssignmentLateDueDate;
    private List<Double> newAssignmentPercentageReduction;

    // Class Event
    private String newClassType;


    // Reading Event
    private Resource newReadingResource;
    private Boolean newReadingRequired;
    private List<Integer> newReadingPages;

    // Study Event
    private List<String> newStudyTodo;

    // Constructors
    public UpdateEventInputData(String newName, Course newCourse, LocalDateTime newStartTime,
                                LocalDateTime newEndTime, Location newLocation, boolean newCompleted,
                                String newAssignmentType, int newAssignmentPercentage,
                                boolean newAssignmentRequired, LocalDateTime newAssignmentLateDueDate,
                                List<Double> newAssignmentPercentageReduction, String newClassType,
                                Resource newReadingResource, boolean newReadingRequired,
                                List<Integer> newReadingPages, List<String> newStudyTodo) {
        // this.event = event;
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
    // public Event getEvent() {
       // return event;
    // }

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


    // Setters - to update
    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewCourse(Course newCourse) {
        this.newCourse = newCourse;
    }

    public void setNewStartTime(LocalDateTime newStartTime) {
        this.newStartTime = newStartTime;
    }

    public void setNewEndTime(LocalDateTime newEndTime) {
        this.newEndTime = newEndTime;
    }

    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    public void setNewCompleted(Boolean newCompleted) {
        this.newCompleted = newCompleted;
    }

    public void setNewAssignmentType(String newAssignmentType) {
        this.newAssignmentType = newAssignmentType;
    }

    public void setNewAssignmentPercentage(int newAssignmentPercentage) {
        this.newAssignmentPercentage = newAssignmentPercentage;
    }

    public void setNewAssignmentRequired(boolean newAssignmentRequired) {
        this.newAssignmentRequired = newAssignmentRequired;
    }

    public void setNewAssignmentLateDueDate(LocalDateTime newAssignmentLateDueDate) {
        this.newAssignmentLateDueDate = newAssignmentLateDueDate;
    }

    public void setNewAssignmentPercentageReduction(List<Double> newAssignmentPercentageReduction) {
        this.newAssignmentPercentageReduction = newAssignmentPercentageReduction;
    }

    public void setNewClassType(String newClassType) {
        this.newClassType = newClassType;
    }

    public void setNewReadingResource(Resource newReadingResource) {
        this.newReadingResource = newReadingResource;
    }

    public void setNewReadingRequired(boolean newAssignmentRequired) {
        this.newReadingRequired = newAssignmentRequired;
    }

    public void setNewReadingPages(List<Integer> newReadingPages) {
        this.newReadingPages = newReadingPages;
    }

    public void  setNewStudyTodo(List<String> newStudyTodo) {
        this.newStudyTodo = newStudyTodo;
    }

}
