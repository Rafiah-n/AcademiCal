package use_case.login;

import entity.User;

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
            loginPresenter.prepareFailView(email + ":Email does not exist");
        } else {
            String pwd = userDataAccessObject.get(loginInputData.getEmail()).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect Password for" + email + ".");
            } else {
                User user = userDataAccessObject.get(loginInputData.getEmail());

                LoginOutputData loginOutputData = new LoginOutputData(user.getEmail(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
