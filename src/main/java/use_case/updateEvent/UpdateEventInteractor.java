package use_case.updateEvent;

import entity.Event;

public class UpdateEventInteractor implements UpdateEventInputBoundary {
    final UpdateEventDataAccessInterface updateEventDataAccessObject;
    final UpdateEventOutputBoundary updateEventPresenter;

    public UpdateEventInteractor(UpdateEventDataAccessInterface updateEventDataAccessInterface,
                                 UpdateEventOutputBoundary updateEventOutputBoundary){
        this.updateEventDataAccessObject = updateEventDataAccessInterface;
        this.updateEventPresenter = updateEventOutputBoundary;
    }



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
