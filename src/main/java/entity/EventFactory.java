package entity;

import java.time.LocalDateTime;

public interface EventFactory {

    Event create(String name, LocalDateTime startTime, LocalDateTime endTime);
}
