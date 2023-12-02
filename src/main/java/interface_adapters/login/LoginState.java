package interface_adapters.login;

public class LoginState {
    private String email = "";
    private String emailError = null;
    private String password = "";
    private String passwordError = null;

    public LoginState(LoginState copy) {
        email = copy.email;
        emailError = copy.emailError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    public LoginState(){}
    /**
     * Return the email of the user.
     * @return email of the user.
     */
    public String getEmail(){return email;}

    /**
     * Return an error message about the email.
     * @return an error message about the email.
     */
    public String getEmailError(){return emailError;}

    /**
     * Return the password of the user.
     * @return the password of the user.
     */
    public String getPassword(){return password;}

    /**
     * Retrieves the password error message.
     * @return The password error message, or null/empty string if no error is present.
     */
    public String getPasswordError(){return passwordError;}

    /**
     * Sets the email address.
     * @param email The new email address to be set. It must be a valid email format.
     */
    public void setEmail(String email){this.email = email;}

    /**
     * Sets the email error message.
     * @param emailError the error message to be set.
     */
    public void setEmailError(String emailError){this.emailError = emailError;}

    /**
     * Sets the password of the user.
     * @param password the password to be set.
     */
    public void setPassword(String password){this.password = password;}

    /**
     * Sets the password error message.
     * @param passwordError the password error message to be set.
     */
    public void setPasswordError(String passwordError){this.passwordError = passwordError;}
}
