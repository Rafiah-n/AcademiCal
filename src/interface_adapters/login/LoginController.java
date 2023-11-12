package interface_adapters.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String email, String password){
        LoginInputData loginInputData = new LoginInputData(
                email, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
