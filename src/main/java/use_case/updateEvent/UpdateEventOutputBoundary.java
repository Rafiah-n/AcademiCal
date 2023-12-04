package use_case.updateEvent;


/**
 * The UpdateEventOutputBoundary interface defines the boundary for preparing success and failure views
 * related to the use case of updating events.
 * Implementing classes should provide methods to handle success and failure scenarios.
 *
 * @author Kubra
 * @version 1.0
 * @since Dec 1, 2023
 */
public interface UpdateEventOutputBoundary {
    void prepareSuccessView(UpdateEventOutputData event);

    void prepareFailView(String error);
}
