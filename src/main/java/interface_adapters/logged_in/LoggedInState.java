package main.java.interface_adapters.logged_in;

public class LoggedInState {
    private String email = "";

    public LoggedInState(LoggedInState copy) {
        email = copy.email;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
