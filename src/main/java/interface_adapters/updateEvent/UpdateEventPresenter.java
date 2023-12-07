package interface_adapters.updateEvent;

import interface_adapters.ViewManagerModel;
import interface_adapters.ViewModel;
import interface_adapters.logged_in.LoggedInViewModel;
import use_case.updateEvent.UpdateEventOutputBoundary;
import use_case.updateEvent.UpdateEventOutputData;
import view.updateEvent.UpdateEventView;


/**
 * The UpdateEventPresenter class acts as an interface between the Use Case layer (Interactor) and the UI layer (View).
 * It receives output from the Use Case layer, updates the UpdateEventViewModel, and triggers UI updates.
 * The purpose is to decouple the business logic from the UI.
 * Note: This class follows the Presenter pattern in the context of the Model-View-Presenter (MVP) architecture.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */

public class UpdateEventPresenter implements UpdateEventOutputBoundary {

    private final UpdateEventViewModel updateEventViewModel;
    private ViewManagerModel viewManagerModel;
    private UpdateEventController updateEventController;

    /**
     * Constructs an UpdateEventPresenter with the specified ViewManagerModel and UpdateEventViewModel.
     *
     * @param viewManagerModel    The ViewManagerModel for managing views in the application.
     * @param updateEventViewModel The UpdateEventViewModel for managing the view's state.
     */
    public UpdateEventPresenter(ViewManagerModel viewManagerModel,
                                UpdateEventViewModel updateEventViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.updateEventViewModel = updateEventViewModel;
    }


    /**
     * Prepares the view for a successful update event operation.
     *
     * @param response The output data containing the updated event and operation status.
     */
    public void prepareSuccessView(UpdateEventOutputData response) {
        UpdateEventViewModel updateEventViewModel = new UpdateEventViewModel();
        UpdateEventState updateEventState = updateEventViewModel.getState();
        updateEventState.setEvent(response.getEvent());
        this.updateEventViewModel.setState(updateEventState);
        this.updateEventViewModel.firePropertyChanged();
        UpdateEventView updateEventView = new UpdateEventView(updateEventViewModel, updateEventController);
        updateEventView.showPopup("Event successfully updated: " + response);

        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    /**
     * Prepares the view for a failed update event operation.
     *
     * @param error The error message indicating the reason for the failure.
     */
    public void prepareFailView(String error) {
        UpdateEventState updateEventState = updateEventViewModel.getState();
        updateEventState.setErrorMessage(error);
        updateEventViewModel.firePropertyChanged();
        UpdateEventView updateEventView = new UpdateEventView(updateEventViewModel, updateEventController);
        updateEventView.showPopup("Event successfully updated: " + error);

    }
}
