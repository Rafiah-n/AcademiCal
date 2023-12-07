package entity;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonUser implements User{

    private final String email;
    private final String password;
    private final LocalDateTime creationTime;

    /**
     * Requires: password is valid.
     * @param email
     * param password
     */
    CommonUser(String email, String password, LocalDateTime creationTime){
        this.email = email;
        this.password = password;
        this.creationTime =  creationTime;
    }

    @Override
    public String getEmail(){return email;}

    @Override
    public String getPassword(){return password;}

    @Override
    public LocalDateTime getCreationTime(){return creationTime;}
}
