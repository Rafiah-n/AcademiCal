package main.java.interface_adapters.login;

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

    public String getEmail(){return email;}

    public String getEmailError(){return emailError;}

    public String getPassword(){return password;}

    public String getPasswordError(){return passwordError;}

    public void setEmail(String email){this.email = email;}

    public void setEmailError(String emailError){this.emailError = emailError;}

    public void setPassword(String password){this.password = password;}

    public void setPasswordError(String passwordError){this.passwordError = passwordError;}
}
