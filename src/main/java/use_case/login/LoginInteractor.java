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

    /**
     * Executes the login use case with the provided login input data.
     * This method performs the login operation using the provided {@code LoginInputData} object,
     * checking the validity of the email and password, and preparing the appropriate view through the {@code loginPresenter}.
     * If the email does not exist or the password is incorrect, the failure view is prepared with an error message.
     * If the login is successful, the success view is prepared with relevant user information and associated events.
     *
     * @param loginInputData The input data for the login operation, including the email and password.
     */
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
