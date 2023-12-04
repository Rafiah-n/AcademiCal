package interface_adapters.updateEvent;

import entity.Event;
import use_case.updateEvent.UpdateEventInputBoundary;
import use_case.updateEvent.UpdateEventInputData;

/**
 * The UpdateEventController class acts as an interface between the UI layer (View) and the Use Case layer (Interactor).
 * It receives user input from the UI, creates an UpdateEventInputData object, and passes it to the UpdateEventInputBoundary.
 * The purpose is to decouple the UI from the business logic.
 * Note: This class follows the Controller pattern in the context of the Model-View-Controller (MVC) architecture.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
public class UpdateEventController {
    final UpdateEventInputBoundary updateEventUseCaseInteractor;

    /**
     * Constructs an UpdateEventController with the specified UpdateEventInputBoundary.
     *
     * @param updateEventUseCaseInteractor The UpdateEventInputBoundary for handling the update event use case.
     */
    public UpdateEventController(UpdateEventInputBoundary updateEventUseCaseInteractor) {
        this.updateEventUseCaseInteractor = updateEventUseCaseInteractor;
    }

    /**
     * Executes the update event use case by creating an UpdateEventInputData object and passing it to the interactor.
     *
     * @param event The event to be updated.
     */
    public void execute(Event event){
        UpdateEventInputData updateEventInputData = new UpdateEventInputData(event);

        updateEventUseCaseInteractor.execute(updateEventInputData);
    }
}
