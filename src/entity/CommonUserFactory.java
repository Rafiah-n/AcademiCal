package entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements UserFactory{
    /**
     * Requires: password is valid.
     * @param email
     * @param password
     * @return
     */

    @Override
    public User create(String email, String password, LocalDateTime ltd){
        return new CommonUser(email, password, ltd);
    }
}
