package use_case.updateEvent;

import entity.Event;

/**
 * The UpdateEventOutputData class encapsulates the output data for the use case of updating events.
 * It contains the updated event and a flag indicating whether the use case execution failed.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
public class UpdateEventOutputData {
    private final Event updatedEvent;
    private boolean useCaseFailed;

    /**
     * Constructs an UpdateEventOutputData object with the specified updated event and use case failure status.
     *
     * @param updatedEvent The event that has been successfully updated.
     * @param useCaseFailed True if the use case execution failed, false otherwise.
     */
    public UpdateEventOutputData(Event updatedEvent, boolean useCaseFailed) {
        this.updatedEvent = updatedEvent;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the updated event associated with this output data.
     *
     * @return The updated event.
     */
    public Event getEvent(){return updatedEvent;}
}
