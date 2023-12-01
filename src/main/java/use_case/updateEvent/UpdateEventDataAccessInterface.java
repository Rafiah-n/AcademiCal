package use_case.updateEvent;

import entity.Event;

public interface UpdateEventDataAccessInterface {

    void save(Event event);

    void update(Event event);

    Event get(Long id);
}
