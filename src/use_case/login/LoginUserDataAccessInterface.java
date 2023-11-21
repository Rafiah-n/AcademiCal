package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByEmail(String identifier);

    void save(User user);

    User get(String email);
}
