package interface_adapters.updateEvent;

import entity.Course;
import entity.Event;
import entity.Location;
import entity.Resource;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The UpdateEventState class represents the state of the UpdateEventView.
 * It contains fields for various properties related to an event, including errors.
 * This class is used to manage the state of the UI and facilitate communication between the View and ViewModel.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
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

    /**
     * Constructs an UpdateEventState with the specified initial state.
     *
     * @param state The initial state to copy.
     */
    public UpdateEventState(UpdateEventState state) {
        this.event = state.event;
    }

    /**
     * Default constructor for UpdateEventState.
     */
    public UpdateEventState() {

    }

    /**
     * Gets the current event in the state.
     *
     * @return The current event.
     */
    public Event getEvent(){
        return event;
    }


    /**
     * Sets the current event in the state.
     *
     * @param event The event to set.
     * @return The updated event.
     */
    public Event setEvent(Event event){
        return this.event = event;
    }


    /**
     * Gets the error message associated with the state.
     *
     * @return The error message.
     */
    public String getErrorMessage(){
        return errorMessage;
    }


    /**
     * Sets the error message associated with the state.
     *
     * @param errorMessage The error message to set.
     */
    public void setErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
