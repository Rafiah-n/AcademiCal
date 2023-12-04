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


/**
 * The UpdateEventUseCaseFactory class provides a method to create an instance of the UpdateEventView.
 * It initializes and orchestrates the necessary components for the update event use case.
 * It handles exceptions related to file operations and displays an error message if needed.
 * Note: This class follows the Factory Method pattern to create an instance of the UpdateEventView.
 * Note: Error handling in this code is minimal and should be enhanced for production use.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */
public class UpdateEventUseCaseFactory {
    private UpdateEventUseCaseFactory() {}


    /**
     * Creates and returns an instance of the UpdateEventView for the update event use case.
     *
     * @param viewManagerModel           The ViewManagerModel for managing views in the application.
     * @param updateEventViewModel       The UpdateEventViewModel for managing the view's state.
     * @param updateEventDataAccessInterface The UpdateEventDataAccessInterface for accessing event data.
     * @param event                      The event to be updated.
     * @return An instance of the UpdateEventView.
     */
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
