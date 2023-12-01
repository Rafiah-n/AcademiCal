package app;


import entity.CommonUserFactory;
import entity.UserFactory;
import entity.Event;
import interface_adapters.ViewManagerModel;
import interface_adapters.updateEvent.UpdateEventController;
import interface_adapters.updateEvent.UpdateEventPresenter;
import interface_adapters.updateEvent.UpdateEventViewModel;
import use_case.updateEvent.UpdateEventInputBoundary;
import use_case.updateEvent.UpdateEventInteractor;
import use_case.updateEvent.UpdateEventOutputBoundary;
import use_case.updateEvent.UpdateEventDataAccessInterface;
import view.updateEvent.*;

import javax.swing.*;
import java.io.IOException;

public class UpdateEventUseCaseFactory {
    private UpdateEventUseCaseFactory() {}

    public static UpdateEventView create(
            ViewManagerModel viewManagerModel,
            UpdateEventViewModel updateEventViewModel,
            UpdateEventDataAccessInterface updateEventDataAccessInterface,
            Event event ) {
        try {
            UpdateEventController updateEventController = createUpdateEventUseCase(viewManagerModel, updateEventViewModel, updateEventDataAccessInterface, event);
            return new UpdateEventView(updateEventViewModel, updateEventController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }

    private static UpdateEventController createUpdateEventUseCase(
            ViewManagerModel viewManagerModel,
            UpdateEventViewModel updateEventViewModel,
            UpdateEventDataAccessInterface updateEventDataAccessObject,
            Event event) throws IOException{

        UpdateEventOutputBoundary updateEventOutputBoundary = new UpdateEventPresenter(viewManagerModel, updateEventViewModel); //loggedInViewModel

        UserFactory userFactory = new CommonUserFactory();

        UpdateEventInputBoundary updateEventInteractor = new UpdateEventInteractor(
                updateEventDataAccessObject, updateEventOutputBoundary);

        return new UpdateEventController(updateEventInteractor);
    }
}
