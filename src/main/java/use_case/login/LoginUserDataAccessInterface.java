package main.java.use_case.login;

import main.java.entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByEmail(String identifier);

    void save(User user);

    User get(String email);
}
