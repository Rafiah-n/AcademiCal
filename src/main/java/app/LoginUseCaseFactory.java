package main.java.app;

import main.java.entity.CommonUserFactory;
import main.java.entity.UserFactory;
import main.java.interface_adapters.ViewManagerModel;
import main.java.interface_adapters.logged_in.LoggedInViewModel;
import main.java.interface_adapters.login.LoginController;
import main.java.interface_adapters.login.LoginPresenter;
import main.java.interface_adapters.login.LoginViewModel;
import main.java.use_case.login.LoginInputBoundary;
import main.java.use_case.login.LoginInteractor;
import main.java.use_case.login.LoginOutputBoundary;
import main.java.use_case.login.LoginUserDataAccessInterface;
import main.java.view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory() {}

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
