package use_case.login;

import entity.Event;
import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface LoginUserDataAccessInterface {
    boolean existsByEmail(String identifier);

    void save(User user);

    User get(String email);

    ArrayList<Event> Events() throws IOException, GeneralSecurityException;
}
