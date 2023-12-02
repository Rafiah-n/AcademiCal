package use_case.login;

import interface_adapters.logged_in.LoggedInState;

import java.util.ArrayList;

public class LoginOutputData {
    private final String email;
    private final ArrayList<String> userEvents;
    private boolean useCaseFailed;

    public LoginOutputData(String email, boolean useCaseFailed, ArrayList<String> userEvents) {
        this.email = email;
        this.userEvents = userEvents;
        this.useCaseFailed = useCaseFailed;
    }

    public String getEmail(){return email;}

    public ArrayList<String> getUserEvents(){return userEvents;}
}
