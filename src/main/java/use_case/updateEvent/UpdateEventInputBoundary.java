package use_case.updateEvent;

import use_case.updateEvent.UpdateEventInputData;

public interface UpdateEventInputBoundary {
    void execute(UpdateEventInputData updateEventInputData);
}