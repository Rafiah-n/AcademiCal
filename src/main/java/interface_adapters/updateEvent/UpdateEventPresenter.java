package interface_adapters.updateEvent;

import interface_adapters.ViewManagerModel;
import use_case.updateEvent.UpdateEventOutputBoundary;
import use_case.updateEvent.UpdateEventOutputData;

public class UpdateEventPresenter implements UpdateEventOutputBoundary {

    private final UpdateEventViewModel updateEventViewModel;
    private ViewManagerModel viewManagerModel;

    public UpdateEventPresenter(ViewManagerModel viewManagerModel,
                                UpdateEventViewModel updateEventViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.updateEventViewModel = updateEventViewModel;
    }

    public void prepareSuccessView(UpdateEventOutputData response) {
        //LoggedInState loggedInState = loggedInViewModel.getState();
       // loggedInState.setEmail(response.getEmail());
        // this.loggedInViewModel.setState(loggedInState);
        //this.loggedInViewModel.firePropertyChanged();

       // this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        UpdateEventState updateEventState = updateEventViewModel.getState();
        updateEventState.setErrorMessage(error);
        updateEventViewModel.firePropertyChanged();
    }
}
