package use_case.update_event;
import entity.*;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventInputDataInteractor {

    // for common attributes
    public static void updateEventName(Event event, String newName) {
        event.setName(newName);
    }

    public static void updateEventCourse(Event event, Course newCourse) {
        event.setCourse(newCourse);
    }

    public static void updateEventStartTime(Event event, LocalDateTime newStartTime) {
        event.setStartTime(newStartTime);
    }

    public static void updateEventEndTime(Event event, LocalDateTime newEndTime) {
        event.setEndTime(newEndTime);
    }

    public static void updateEventLocation(Event event, Location newLocation) {
        event.setLocation(newLocation);
    }

    public static void updateEventCompleted(Event event, Boolean newCompleted) {
        event.setCompleted(newCompleted);
    }


    // methods to update attributes specific to Assignment Event
    public static void updateAssignmentType(AssignmentEvent assignmentEvent, String newAssignmentType) {
        assignmentEvent.setType(newAssignmentType);
    }

    public static void updateAssignmentPercentage(AssignmentEvent assignmentEvent, int newAssignmentPercentage) {
        assignmentEvent.setPercentage(newAssignmentPercentage);
    }

    public static void updateAssignmentRequired(AssignmentEvent assignmentEvent, boolean newAssignmentRequired) {
        assignmentEvent.setRequired(newAssignmentRequired);
    }

    public static void updateAssignmentLateDueDate(AssignmentEvent assignmentEvent, LocalDateTime newAssignmentLateDueDate) {
        assignmentEvent.setLateDueDate(newAssignmentLateDueDate);
    }

    public static void updateAssignmentPercentageReduction(AssignmentEvent assignmentEvent, List<Double> newAssignmentPercentageReduction) {
        assignmentEvent.setPercentageReduction(newAssignmentPercentageReduction);
    }


    // methods to update attributes specific to Class Event
    public static void updateClassType(ClassEvent classEvent, String newClassType) {
        classEvent.setType(newClassType);
    }


    // methods to update attributes specific to Reading Event
    public static void updateReadingResource(ReadingEvent readingEvent, Resource newReadingResource) {
        readingEvent.setResource(newReadingResource);
    }

    public static void updateReadingRequired(ReadingEvent readingEvent, boolean newReadingRequired) {
        readingEvent.setRequired(newReadingRequired);
    }

    public static void updateReadingPages(ReadingEvent readingEvent, List<Integer> newReadingPages) {
        readingEvent.setPages(newReadingPages);
    }

    // methods to update attributes specific to Study Event
    public static void updateStudyTodoList(StudyEvent studyEvent, List<String> newStudyTodo) {
        studyEvent.addTodo(newStudyTodo.toString());
    }
}
