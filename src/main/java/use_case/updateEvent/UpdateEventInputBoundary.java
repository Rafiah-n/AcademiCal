package use_case.updateEvent;

import use_case.updateEvent.UpdateEventInputData;

/**
 * The UpdateEventInputBoundary interface defines the boundary for executing the use case of updating events.
 * Implementing classes should provide the execute method that takes an instance of UpdateEventInputData.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
public interface UpdateEventInputBoundary {
    void execute(UpdateEventInputData updateEventInputData);
}