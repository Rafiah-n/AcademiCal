package use_case.login;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import data_access.FileUserDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.*;
import interface_adapters.login.LoginController;

import static org.junit.Assert.*;


public class LoginInteractorTest {

    static String email = "abc123@gmail.com";
    static String password = "Abc123";


    @org.junit.Test
    public void testLoginInputData() {
        LoginInputData inputData = new LoginInputData(email, password);
        assert(inputData.getEmail().equals(email));
        assert(inputData.getPassword().equals(password));
    }

    @org.junit.Test
    public void testLoginOutputData() throws GeneralSecurityException, IOException {
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        ArrayList<Event> eventList = userRepository.Events();
        ArrayList<String> eventNames = new ArrayList<>();
        for (Event event : eventList) {
            eventNames.add(event.getName());
        }
        LoginOutputData outputData = new LoginOutputData(email, false, eventNames);
        assert(outputData.getEmail().equals(email));
        assert(outputData.getUserEvents().equals(eventNames));
    }

    @org.junit.Test
    public void successView() {
        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create(email, password, LocalDateTime.now());
        LoginInputData inputData = new LoginInputData(email, password);
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        userRepository.save(user);

        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals(email, user.getEmail());
                assertTrue(userRepository.existsByEmail(email));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @org.junit.Test
    public void failureIncorrectPassword() {
        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create(email, password, LocalDateTime.now());
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        userRepository.save(user);

        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect email or password.", error);
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        LoginController controller = new LoginController(interactor);
        controller.execute(email, "password");
    }

    @org.junit.Test
    public void failureIncorrectEmail() {
        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create(email, password, LocalDateTime.now());
        LoginInputData inputData = new LoginInputData("abc1234@gmail.com", password);
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        userRepository.save(user);

        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect email or password.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }
}
