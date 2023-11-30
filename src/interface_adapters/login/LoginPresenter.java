package interface_adapters.login;

import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

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
