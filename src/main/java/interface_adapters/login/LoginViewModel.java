package interface_adapters.login;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {
    public final String TITLE_LABEL = "Log In View";
    public final String EMAIL_LABEL = "Enter email";
    public final String PASSWORD_LABEL = "Enter password";
    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private LoginState state = new LoginState();

    public LoginViewModel(){super("log in");}

    /**
     * Sets the state for the current instance of the login view model.
     * This method updates the internal state of the login view model with the provided {@code LoginState}.
     * The state typically contains information about the current state of the login view, such as error messages,
     * validation flags, or other relevant properties.
     *
     * @param state The new {@code LoginState} to be set for the login view model.
     */
    public void setState(LoginState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){support.firePropertyChange("state",null, this.state);}

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the login functionality.
     *
     * This method returns the current {@code LoginState} associated with the login functionality.
     * The {@code LoginState} object encapsulates information about the current state of the login component,
     * including any error messages or relevant data.
     *
     * @return The current {@code LoginState} representing the state of the login functionality.
     */
    public LoginState getState(){return state;}
}
