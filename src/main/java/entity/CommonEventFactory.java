package entity;

import java.time.LocalDateTime;

public class CommonEventFactory implements EventFactory{
    private Course course = new Course();

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime, String location,
                        boolean completed) {
        Location location1 = new Location();
        location1.setAddress(location);
        return new Event(name, course, startTime, endTime, location1, completed);
    }
}
