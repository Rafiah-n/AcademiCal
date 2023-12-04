package interface_adapters;

import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class CreateEventState {

    private Event event;
    private String eventName = "";
    private Course course;
    private boolean eventCompleted;
    private String assignmentType = "";
    private int assignmentPercentage;
    private boolean assignmentRequired;
    private Resource resource;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime lateDueDate;;
    private Location location;
    private List<Double> percentageReduction;
    private String classType;
    private List<Integer> readingPages;
    private List<String> studyTodo;
    private String errorMessage = "Error occured";

    public CreateEventState(CreateEventState state) {
        this.event = state.event;
    }
    public CreateEventState() {

    }
    public Event getEvent(){
        return event;
    }

    public Event setEvent(Event event){
        return this.event = event;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }

    public void setEventName(String name){
        eventName = name;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public void setEventCompleted(boolean bool){
        eventCompleted = bool;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setAssignmentType(String type){
        assignmentType = type;
    }

    public void setAssignmentPercentage(int perc){
        assignmentPercentage = perc;
    }

    public void setResource(Resource resource){
        this.resource = resource;
    }

    public void setAssignmentRequired(boolean req){
        assignmentRequired = req;
    }

    public void setStartTime(LocalDateTime time){
        startTime = time;
    }

    public void setEndTime(LocalDateTime time){
        endTime = time;
    }

    public void setLateDueDate(LocalDateTime time){
        lateDueDate = time;
    }

    public void setPercentageReduction(List<Double> list){
        percentageReduction = list;
    }

    public void setClassType(String type){
        classType = type;
    }

    public void setReadingPages(List<Integer> pages){
        readingPages = pages;
    }

    public void setStudyTodo(List<String> todo){
        studyTodo = todo;
    }
}
