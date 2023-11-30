package entity;

import java.util.List;

public class FoundEvent {

    private Event event;
    private List<Integer> span;

    public FoundEvent(Event event, List<Integer> span) {
        this.event = event;
        this.span = span;
    }
    public Event getEvent() {
        return event;
    }
    public List<Integer> getEndpoints() {
        return span;
    }

    @Override
    public String toString() {
        return "FoundEvent{" +
                "event=" + event.toString() +
                ", endpoints=" + span +
                '}';
    }
}
