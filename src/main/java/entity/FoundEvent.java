package entity;

import java.util.List;

public class FoundEvent {

    private Event event;
    private String highlight;
    private List<Integer> endpoints;

    public FoundEvent(Event event, String highlight, List<Integer> endpoints) {
        this.event = event;
        this.highlight = highlight;
        this.endpoints = endpoints;
    }
    public Event getEvent() {
        return event;
    }
    public List<Integer> getEndpoints() {
        return endpoints;
    }
    public String getHighlightedText() {
        return highlight;
    }

    @Override
    public String toString() {
        return "FoundEvent{" +
                "event=" + event +
                ", highlight='" + highlight + '\'' +
                ", endpoints=" + endpoints +
                '}';
    }
}
