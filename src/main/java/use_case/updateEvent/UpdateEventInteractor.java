package use_case.updateEvent;

import entity.Event;

/**
 * The UpdateEventInteractor class implements the UpdateEventInputBoundary interface and represents the interactor
 * responsible for updating events. It interacts with data access objects and prepares the output view.
 * It validates the input data and updates the event in the data source.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
public class UpdateEventInteractor implements UpdateEventInputBoundary {
    final UpdateEventDataAccessInterface updateEventDataAccessObject;
    final UpdateEventOutputBoundary updateEventPresenter;


    /**
     * Constructs an UpdateEventInteractor with the specified data access interface and output presenter.
     *
     * @param updateEventDataAccessInterface The data access interface for updating events in the data source.
     * @param updateEventOutputBoundary The output presenter for updating events in the view.
     */
    public UpdateEventInteractor(UpdateEventDataAccessInterface updateEventDataAccessInterface,
                                 UpdateEventOutputBoundary updateEventOutputBoundary){
        this.updateEventDataAccessObject = updateEventDataAccessInterface;
        this.updateEventPresenter = updateEventOutputBoundary;
    }



    /**
     * Executes the use case for updating events based on the provided input data.
     *
     * @param updateEventInputData The input data containing information for updating events.
     */
    @Override
    public void execute(UpdateEventInputData updateEventInputData) {
        Event event = updateEventInputData.getEvent();
        System.out.println("in execute: " + event.getName());
        boolean isValid = validate(updateEventInputData.getEvent());

        if(!isValid) {
            updateEventPresenter.prepareFailView("Validation Failed Check your input");
        }

        //update event with google api
        updateEventDataAccessObject.update(event);

        UpdateEventOutputData updateEventOutputData = new UpdateEventOutputData(event, false);
        updateEventPresenter.prepareSuccessView(updateEventOutputData);
    }

    private boolean validate(Event event) {

         /* String email = updateEventInputData.getEvent().getName();
        String password = updateEventInputData.getEvent().getName();
        if (!updateEventDataAccessObject.get(1L).getCompleted()) { //existsByEmail(email)
            updateEventPresenter.prepareFailView("Incorrect email or password.");
        } else {
            String pwd = updateEventDataAccessObject.get(1L).getName();
            if (!password.equals(pwd)) {
                updateEventPresenter.prepareFailView("Incorrect email or password.");
            } else {
                Event event = updateEventDataAccessObject.get(1L);

                UpdateEventOutputData updateEventOutputData = new UpdateEventOutputData(event, false);
                updateEventPresenter.prepareSuccessView(updateEventOutputData);
            }
        }
        */
        return true;
    }
}
