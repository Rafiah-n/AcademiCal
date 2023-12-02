package main.java.entity;

import java.util.List;

/**
 * The {@code FoundEvent} class represents the result of an event extraction operation,
 * encapsulating information about the extracted event and the span of the text from which
 * the event information was derived.
 * <p>
 * An instance of this class is typically returned by services or methods that perform
 * event extraction operations, providing access to the extracted event and information
 * about the location of the text within the input source.
 *
 * @author Leo (padril) Peckham
 * @version 1.0
 * @see Event
 */
public class FoundEvent {

    /**
     * The {@code Event} object containing information about the extracted event.
     */
    private Event event;

    /**
     * The list of two integers representing the start and end points of the text or
     * highlight from where the event information was extracted.
     */
    private List<Integer> span;

    /**
     * Constructs a new {@code FoundEvent} instance with the specified {@code Event} object
     * and the span of the text.
     *
     * @param event the extracted event information
     * @param span  the span of the text, represented by a list of two integers denoting
     *              the start and end points
     */
    public FoundEvent(Event event, List<Integer> span) {
        this.event = event;
        this.span = span;
    }

    /**
     * Gets the {@code Event} object containing information about the extracted event.
     *
     * @return the {@code Event} object
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Gets the list of two integers representing the start and end points of the text
     * or highlight from where the event information was extracted.
     *
     * @return the span of the text
     */
    public List<Integer> getEndpoints() {
        return span;
    }

    /**
     * Returns a string representation of the {@code FoundEvent} object, including
     * details about the encapsulated event and the span of the text.
     *
     * @return a string representation of the {@code FoundEvent}
     */
    @Override
    public String toString() {
        return "FoundEvent{" +
                "event=" + event.toString() +
                ", endpoints=" + span +
                '}';
    }
}