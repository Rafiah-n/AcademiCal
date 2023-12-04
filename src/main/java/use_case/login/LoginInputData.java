package use_case.login;

public class LoginInputData {
    final private String email;
    final private String password;

    public LoginInputData(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     * Retrieves the email associated with the current instance.
     * @return A {@code String} representing the email address. It may be null if no email is set.
     */
    public String getEmail(){return email;}
    /**
     * Retrieves the password associated with the current instance.
     * @return A {@code String} representing the password. It may be null if no password is set.
     */
    public String getPassword(){return password;}
}
