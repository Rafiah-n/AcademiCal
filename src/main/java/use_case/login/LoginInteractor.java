package use_case.login;

import entity.Event;
import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class LoginInteractor implements LoginInputBoundary{
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary){
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String email = loginInputData.getEmail();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByEmail(email)) {
            loginPresenter.prepareFailView("Incorrect email or password.");
        } else {
            String pwd = userDataAccessObject.get(loginInputData.getEmail()).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect email or password.");
            } else {
                User user = userDataAccessObject.get(loginInputData.getEmail());
                ArrayList<Event> userEvents = null;
                try {
                    userEvents = userDataAccessObject.Events();
                } catch (IOException | GeneralSecurityException ignored) {
                }
                ArrayList<String> nameEvents = new ArrayList<>();
                assert userEvents != null;
                for(Event event: userEvents) {
                    nameEvents.add(event.getName());
                }
                LoginOutputData loginOutputData = new LoginOutputData(user.getEmail(), false, nameEvents);
                    loginPresenter.prepareSuccessView(loginOutputData);
                }
            }
    }
}
