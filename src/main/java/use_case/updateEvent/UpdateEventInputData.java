package use_case.updateEvent;

import entity.Event;

/**
 * Constructs an UpdateEventInputData object with the specified event.
 *
 * @param event The event to be updated.
 */
public class UpdateEventInputData {
    final private Event event;

    public UpdateEventInputData(Event event) {
        this.event = event;
    }

    /**
     * Gets the event associated with this input data.
     *
     * @return The event to be updated.
     */
    public Event getEvent(){
        return event;
    }

}
