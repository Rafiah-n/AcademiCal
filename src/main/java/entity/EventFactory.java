package entity;

import java.time.LocalDateTime;

public interface EventFactory {

    Event create(String name, LocalDateTime startTime, LocalDateTime endTime, String location,
                 boolean completed, String eventId);
}

