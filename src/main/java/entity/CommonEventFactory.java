package entity;

import java.time.LocalDateTime;

public class CommonEventFactory implements EventFactory{

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime) {
        Event event = new RandomEvent();
        event.setName(name);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        return event;
    }
}
