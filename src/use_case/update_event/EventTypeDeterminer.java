package use_case.update_event;

import entity.*;

public class EventTypeDeterminer {
    public static String determineEventType(Event event) {
        if (event instanceof AssignmentEvent) {
            return "Assignment";
        } else if (event instanceof ClassEvent) {
            return "Class";
        } else if (event instanceof ReadingEvent) {
            return "Reading";
        } else if (event instanceof StudyEvent) {
            return "Study";
        } else {
            // Handle unknown event types or return a default type
            throw new IllegalArgumentException("Unknown event type");
        }
    }
}
