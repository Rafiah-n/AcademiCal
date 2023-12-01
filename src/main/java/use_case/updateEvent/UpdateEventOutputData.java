package use_case.updateEvent;

import entity.Event;
public class UpdateEventOutputData {
    private final Event updatedEvent;
    private boolean useCaseFailed;

    public UpdateEventOutputData(Event updatedEvent, boolean useCaseFailed) {
        this.updatedEvent = updatedEvent;
        this.useCaseFailed = useCaseFailed;
    }

    public Event getEvent(){return updatedEvent;}
}
