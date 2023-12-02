package interface_adapters.logged_in;

import java.util.ArrayList;

public class LoggedInState {
    private String email = "";
    private ArrayList<String> userEvents = new ArrayList<>();

    public LoggedInState(LoggedInState copy) {
        email = copy.email;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    /**
     * Return the email of the user.
     * @return email of the user.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email address.
     * @param email The new email address to be set. It must be a valid email format.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return events of the user.
     * @return events of the user.
     */
    public ArrayList<String> getUserEvents()  {
        return userEvents;
    }

    /**
     * Set events of the user.
     * @param userEvents the new events of the user.
     */
    public void setUserEvents(ArrayList<String> userEvents) {
        this.userEvents = userEvents;
    }
}
