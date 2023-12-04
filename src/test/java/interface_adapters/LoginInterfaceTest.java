package interface_adapters;

import data_access.InMemoryUserDataAccessObject;
import entity.Event;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginPresenter;
import interface_adapters.login.LoginState;
import interface_adapters.login.LoginViewModel;
import org.junit.Before;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.login.LoginUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class LoginInterfaceTest {

    private String email;
    private String password;
    private ArrayList<String> eventNames = new ArrayList<>();
    private ViewManagerModel managerModel;
    private LoggedInViewModel loggedInViewModel;
    private LoginViewModel loginViewModel;

    @Before
    public void init() throws GeneralSecurityException, IOException {
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        ArrayList<Event> eventList = userRepository.Events();
        for (Event event : eventList) {
            eventNames.add(event.getName());
        }
        password = "Abc123";
        email = "abc123@gmail.com";
        managerModel = new ViewManagerModel();
        loggedInViewModel = new LoggedInViewModel();
        loginViewModel = new LoginViewModel();
    }

    @org.junit.Test
    public void successView() {
        LoginOutputData output = new LoginOutputData(email,false, eventNames);
        LoginOutputBoundary presenter = new LoginPresenter(managerModel, loginViewModel, loggedInViewModel);

        presenter.prepareSuccessView(output);
        LoggedInState loggedInState = loggedInViewModel.getState();

        assert(loggedInState.getEmail().equals(email));
        assert(loggedInState.getUserEvents().equals(eventNames));
        assert(managerModel.getActiveView().equals(loggedInViewModel.getViewName()));
    }

    @org.junit.Test
    public void failureView() {
        LoginOutputData output = new LoginOutputData(email,true, eventNames);
        LoginOutputBoundary presenter = new LoginPresenter(managerModel, loginViewModel, loggedInViewModel);

        presenter.prepareFailView("Incorrect email or password.");
        LoginState loginState = loginViewModel.getState();

        assert(loginState.getEmailError().equals("Incorrect email or password."));
    }

    @org.junit.Test
    public void loginTest() {
        LoginState copyState = new LoginState();
        copyState.setEmail(email);
        copyState.setPassword(password);
        copyState.setEmailError("email error.");
        copyState.setPasswordError("password error.");
        LoginState loginState = new LoginState(copyState);

        assert(loginState.getEmailError().equals("email error."));
        assert(loginState.getPassword().equals(password));
        assert(loginState.getEmail().equals(email));
        assert(loginState.getPasswordError().equals("password error."));
    }

    @org.junit.Test
    public void loggedInViewModeltest() {
        loggedInViewModel.setLoggedInUser(email);
        assert(loggedInViewModel.getLoggedInUser().equals(email));
    }

    @org.junit.Test
    public void loggedInStateTest() {
        LoggedInState loggedInState = new LoggedInState(loggedInViewModel.getState());
        loggedInState.setEmail(email);

        assert(loggedInState.getEmail().equals(email));
    }
}
