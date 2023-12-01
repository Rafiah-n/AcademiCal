package interface_adapters.updateEvent;

import entity.Event;
import use_case.updateEvent.UpdateEventInputBoundary;
import use_case.updateEvent.UpdateEventInputData;

public class UpdateEventController {
    final UpdateEventInputBoundary updateEventUseCaseInteractor;

    public UpdateEventController(UpdateEventInputBoundary updateEventUseCaseInteractor) {
        this.updateEventUseCaseInteractor = updateEventUseCaseInteractor;
    }

    public void execute(Event event){
        UpdateEventInputData updateEventInputData = new UpdateEventInputData(event);

        updateEventUseCaseInteractor.execute(updateEventInputData);
    }
}
