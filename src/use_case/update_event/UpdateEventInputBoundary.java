package use_case.update_event;

import use_case.update_event.Events.UpdateEventInputData;

public interface UpdateEventInputBoundary {
    void execute(UpdateEventInputData updateEventInputData);
}
