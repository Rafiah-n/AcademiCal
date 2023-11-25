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



    // here are the methods for checking whether the current value of an entity is same as the value we
    // want to update to.

    public static boolean isSameValue(Event event, String newName) {
        return (newName.equals(event.getName()));
    }

    public static boolean isSameValue(Event event, Course newCourse) {
        return (newCourse.equals(event.getCourse()));
    }

    public static boolean isSameValue(Event event, LocalDateTime newStartTime) {
        return (newStartTime.equals(event.getStartTime()));
    }

    public static boolean isSameValue(Event event, LocalDateTime newEndTime) {
        return (newEndTime.equals(event.getEndTime()));
    }

    public static boolean isSameValue(Event event, Location newLocation) {
        return (newLocation.equals(event.getLocation()));
    }

    public static boolean isSameValue(AssignmentEvent assignmentEvent, String newAssignmentType) {
        return (newAssignmentType.equals(assignmentEvent.getType()));
    }

    public static boolean isSameValue(AssignmentEvent assignmentEvent, int newAssignmentPercentage) {
        return (newAssignmentPercentage == assignmentEvent.getPercentage());
    }

    public static boolean isSameValue(AssignmentEvent assignmentEvent, boolean newAssignmentRequired) {
        return (newAssignmentRequired == assignmentEvent.isRequired());
    }

    public static boolean isSameValue(AssignmentEvent assignmentEvent, LocalDateTime newAssignmentLateDueDate) {
        return (newAssignmentLateDueDate.equals(assignmentEvent.getLateDueDate()));
    }

    public static boolean isSameValue(AssignmentEvent assignmentEvent, List<Double> newAssignmentPercentageReduction) {
        return (newAssignmentPercentageReduction.equals(assignmentEvent.getPercentageReduction()));
    }

    public static boolean isSameValue(ReadingEvent readingEvent, Resource newReadingResource) {
        return (newReadingResource.equals(readingEvent.getResource()));
    }

    public static boolean isSameValue(ReadingEvent readingEvent, boolean newReadingRequired) {
        return (newReadingRequired == readingEvent.isRequired());
    }

    public static boolean isSameValue(ReadingEvent readingEvent, List<Integer> newReadingPages) {
        return (newReadingPages.equals(readingEvent.getPages()));
    }

    public static boolean isSameValue(StudyEvent studyEvent, List<String> newStudyTodo) {
        return (newStudyTodo.equals(studyEvent.getTodo()));
    }


    public static void execute(UpdateEventInputData updateEventInputData) {

    }
}
