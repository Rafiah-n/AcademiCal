package interface_adapters.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the login operation with the provided email and password.
     * This method creates a {@code LoginInputData} object with the given email and password,
     * encapsulating the input data for the login operation. It then delegates the execution of
     * the login use case to the {@code loginUseCaseInteractor}.
     *
     * @param email The email associated with the login attempt.
     * @param password The password associated with the login attempt.
     */
    public void execute(String email, String password){
        LoginInputData loginInputData = new LoginInputData(
                email, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
