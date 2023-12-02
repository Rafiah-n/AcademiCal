package main.java.entity;

import java.time.LocalDateTime;

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
