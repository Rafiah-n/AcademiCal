package use_case.login;

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
    /**
     * Retrieves the email associated with the current instance.
     * @return A {@code String} representing the email address. It may be null if no email is set.
     */
    public String getEmail(){return email;}

    /**
     * Retrieves the list of user events associated with the current instance.
     * @return An {@code ArrayList<String>} representing the user events.
     * It may be an empty list if no events are present.
     */
    public ArrayList<String> getUserEvents(){return userEvents;}
}
