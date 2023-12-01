package use_case.updateEvent;

import entity.Event;
public class UpdateEventInputData {
    final private Event event;

    public UpdateEventInputData(Event event) {
        this.event = event;
    }

    public Event getEvent(){
        return event;
    }

}
