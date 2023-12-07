package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginController;
import interface_adapters.login.LoginPresenter;
import interface_adapters.login.LoginViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory() {}

    /**
     * Creates an instance of {@code LoginView} with the specified dependencies.
     * This static factory method is responsible for creating and initializing a {@code LoginView} instance
     * with the provided dependencies, including the {@code ViewManagerModel}, {@code LoginViewModel},
     * {@code LoggedInViewModel}, and {@code LoginUserDataAccessInterface}.
     *
     * @param viewManagerModel The model responsible for managing views within the application.
     * @param loginViewModel The model representing the state and data for the login functionality.
     * @param loggedInViewModel The model representing the state and data for the logged-in functionality.
     * @param userDataAccessObject The interface providing access to user data for the login operation.
     * @return A new instance of {@code LoginView} with the specified dependencies.
     *         If an IOException occurs during the creation of the login controller, a JOptionPane is shown,
     *         and the method returns null.
     */
    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel,
                    loggedInViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException{

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, loggedInViewModel);

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}
