package unit_tests;

import app.LoginUseCaseFactory;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUseCaseFactoryUnitTest {

    @Test
    void testCreate() {
        String resourcePath = "src/test/resources/small_users.csv";

        UserFactory userFactory = new CommonUserFactory();

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        LoginUserDataAccessInterface userDataAccessObject = null;
        try {
            userDataAccessObject = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("testCreate failed due to userDataAccessObject");
        }

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);

        assertNotNull(loginView);
    }


}
