package use_case.updateEvent;

import entity.Event;

/**
 * The UpdateEventDataAccessInterface provides an abstraction for data access operations related to updating events.
 * Implementing classes should define methods for saving, updating, and retrieving events from a data source.
 *
 * @author Kubra
 * @version 1.0
 * @since Dec 1, 2023
 */
public interface UpdateEventDataAccessInterface {

    void save(Event event);

    void update(Event event);

    Event get(Long id);
}
