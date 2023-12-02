package interface_adapters.updateEvent;

import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventState {

    private Event event;
    private String eventName = "";

    private String eventNameError = null;

    private Course course;

    private Course courseError = null;

    private boolean eventCompleted;

    private Boolean eventCompletedError = null;

    private String assignmentType = "";

    private String assignmentTypeError = null;

    private int assignmentPercentage;

    private int assignmentPercentageError;

    private boolean assignmentRequired;

    private boolean assignmentRequiredError;

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

    private String errorMessage = "Error occured";

    public UpdateEventState(UpdateEventState state) {
        this.event = state.event;
    }
    public UpdateEventState() {

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
}
