package main.java.interface_adapters.login;

import main.java.interface_adapters.ViewManagerModel;
import main.java.interface_adapters.logged_in.LoggedInState;
import main.java.interface_adapters.logged_in.LoggedInViewModel;
import main.java.use_case.login.LoginOutputBoundary;
import main.java.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel,
                          LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEmail(response.getEmail());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setEmailError(error);
        loginViewModel.firePropertyChanged();
    }
}
