package interface_adapters;

import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventState {

    private String eventName = "";

    private String eventNameError = null;

    private Course course;

    private Course courseError = null;

    private boolean eventCompleted;

    private boolean eventCompletedError = Boolean.parseBoolean(null);


    private String assignmentType = "";

    private String assignmentTypeError = null;

    private int assignmentPercentage;

    private int assignmentPercentageError = Integer.parseInt(null);

    private boolean assignmentRequired;

    private boolean assignmentRequiredError = Boolean.parseBoolean(null);

    private Resource resource;

    private Resource resourceError = null;

    private LocalDateTime startTime;

    private LocalDateTime startTimeError = null;

    private LocalDateTime endTime;

    private LocalDateTime endTimeError = null;

    private LocalDateTime lateDueDate;

    private LocalDateTime lateDueDateError = null;

    private Location location;

    private Location locationError = null;

    private List<Double> percentageReduction;

    private List<Double> percentageReductionError = null;

    private String classType;

    private String classTypeError = null;

    private List<Integer> readingPages;

    private List<Integer> readingPagesError = null;

    private List<String> studyTodo;

    private List<String> studyTodoError = null;


    public UpdateEventState(UpdateEventState copy) {
        this.eventName = copy.eventName;
        this.eventNameError = copy.eventNameError;
        this.course = copy.course;
        this.courseError = copy.courseError;
        this.eventCompleted = copy.eventCompleted;
        this.eventCompletedError = copy.eventCompletedError;
        this.assignmentType = copy.assignmentType;
        this.assignmentTypeError = copy.assignmentTypeError;
        this.assignmentPercentage = copy.assignmentPercentage;
        this.assignmentPercentageError = copy.assignmentPercentageError;
        this.assignmentRequired = copy.assignmentRequired;
        this.assignmentRequiredError = copy.assignmentRequiredError;
        this.resource = copy.resource;
        this.resourceError = copy.resourceError;
        this.startTime = copy.startTime;
        this.startTimeError = copy.startTimeError;
        this.endTime = copy.endTime;
        this.endTimeError = copy.endTimeError;
        this.lateDueDate = copy.lateDueDate;
        this.lateDueDateError = copy.lateDueDateError;
        this.location = copy.location;
        this.locationError = copy.locationError;
        this.percentageReduction = copy.percentageReduction;
        this.percentageReductionError = copy.percentageReductionError;
        this.classType = copy.classType;
        this.classTypeError = copy.classTypeError;
        this.readingPages = copy.readingPages;
        this.readingPagesError = copy.readingPagesError;
        this.studyTodo = copy.studyTodo;
        this.studyTodoError = copy.studyTodoError;
    }


    // getters and setters

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventNameError() {
        return eventNameError;
    }

    public void setEventNameError(String eventNameError) {
        this.eventNameError = eventNameError;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourseError() {
        return courseError;
    }

    public void setCourseError(Course courseError) {
        this.courseError = courseError;
    }

    public boolean isEventCompleted() {
        return eventCompleted;
    }

    public void setEventCompleted(boolean eventCompleted) {
        this.eventCompleted = eventCompleted;
    }

    public boolean isEventCompletedError() {
        return eventCompletedError;
    }

    public void setEventCompletedError(boolean eventCompletedError) {
        this.eventCompletedError = eventCompletedError;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignmentTypeError() {
        return assignmentTypeError;
    }

    public void setAssignmentTypeError(String assignmentTypeError) {
        this.assignmentTypeError = assignmentTypeError;
    }

    public int getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(int assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public int getAssignmentPercentageError() {
        return assignmentPercentageError;
    }

    public void setAssignmentPercentageError(int assignmentPercentageError) {
        this.assignmentPercentageError = assignmentPercentageError;
    }

    public boolean isAssignmentRequired() {
        return assignmentRequired;
    }

    public void setAssignmentRequired(boolean assignmentRequired) {
        this.assignmentRequired = assignmentRequired;
    }

    public boolean isAssignmentRequiredError() {
        return assignmentRequiredError;
    }

    public void setAssignmentRequiredError(boolean assignmentRequiredError) {
        this.assignmentRequiredError = assignmentRequiredError;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResourceError() {
        return resourceError;
    }

    public void setResourceError(Resource resourceError) {
        this.resourceError = resourceError;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTimeError() {
        return startTimeError;
    }

    public void setStartTimeError(LocalDateTime startTimeError) {
        this.startTimeError = startTimeError;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTimeError() {
        return endTimeError;
    }

    public void setEndTimeError(LocalDateTime endTimeError) {
        this.endTimeError = endTimeError;
    }

    public LocalDateTime getLateDueDate() {
        return lateDueDate;
    }

    public void setLateDueDate(LocalDateTime lateDueDate) {
        this.lateDueDate = lateDueDate;
    }

    public LocalDateTime getLateDueDateError() {
        return lateDueDateError;
    }

    public void setLateDueDateError(LocalDateTime lateDueDateError) {
        this.lateDueDateError = lateDueDateError;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocationError() {
        return locationError;
    }

    public void setLocationError(Location locationError) {
        this.locationError = locationError;
    }

    public List<Double> getPercentageReduction() {
        return percentageReduction;
    }

    public void setPercentageReduction(List<Double> percentageReduction) {
        this.percentageReduction = percentageReduction;
    }

    public List<Double> getPercentageReductionError() {
        return percentageReductionError;
    }

    public void setPercentageReductionError(List<Double> percentageReductionError) {
        this.percentageReductionError = percentageReductionError;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassTypeError() {
        return classTypeError;
    }

    public void setClassTypeError(String classTypeError) {
        this.classTypeError = classTypeError;
    }

    public List<Integer> getReadingPages() {
        return readingPages;
    }

    public void setReadingPages(List<Integer> readingPages) {
        this.readingPages = readingPages;
    }

    public List<Integer> getReadingPagesError() {
        return readingPagesError;
    }

    public void setReadingPagesError(List<Integer> readingPagesError) {
        this.readingPagesError = readingPagesError;
    }

    public List<String> getStudyTodo() {
        return studyTodo;
    }

    public void setStudyTodo(List<String> studyTodo) {
        this.studyTodo = studyTodo;
    }

    public List<String> getStudyTodoError() {
        return studyTodoError;
    }

    public void setStudyTodoError(List<String> studyTodoError) {
        this.studyTodoError = studyTodoError;
    }

}
