package interface_adapters.updateEvent;

import interface_adapters.ViewManagerModel;
import interface_adapters.ViewModel;
import interface_adapters.logged_in.LoggedInViewModel;
import use_case.updateEvent.UpdateEventOutputBoundary;
import use_case.updateEvent.UpdateEventOutputData;
import view.updateEvent.UpdateEventView;

public class UpdateEventPresenter implements UpdateEventOutputBoundary {

    private final UpdateEventViewModel updateEventViewModel;
    private ViewManagerModel viewManagerModel;
    private UpdateEventController updateEventController;

    public UpdateEventPresenter(ViewManagerModel viewManagerModel,
                                UpdateEventViewModel updateEventViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.updateEventViewModel = updateEventViewModel;
    }

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

    public void prepareFailView(String error) {
        UpdateEventState updateEventState = updateEventViewModel.getState();
        updateEventState.setErrorMessage(error);
        updateEventViewModel.firePropertyChanged();
        UpdateEventView updateEventView = new UpdateEventView(updateEventViewModel, updateEventController);
        updateEventView.showPopup("Event successfully updated: " + error);

    }
}
