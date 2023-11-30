package use_case.login;

public class LoginInputData {
    final private String email;
    final private String password;

    public LoginInputData(String email, String password){
        this.email = email;
        this.password = password;
    }

    String getEmail(){return email;}

    String getPassword(){return password;}
}
