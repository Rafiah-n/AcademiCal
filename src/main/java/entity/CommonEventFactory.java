package entity;

import java.time.LocalDateTime;

public class CommonEventFactory implements EventFactory{
    private Course course = new Course();

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime, String location,
                        boolean completed, String eventId) {
        Location location1 = new Location();
        location1.setAddress(location);
        Event event = new Event(name, course, startTime, endTime, location1, completed);
        event.setEventId(eventId);
        return event;
    }
}