package main.java.entity;

public class PasswordValidatorService implements PasswordValidator{
    @Override
    public boolean passwordIsValid(String password) {
        if (password.length() <= 5){
            return false;
        }
        // to check space
        if (password.contains(" ")) {
            return false;
        }

        int count = 0;

        // check digits from 0 to 9
        for (int i = 0; i <= 9; i++) {

            String str1 = Integer.toString(i);

            if (password.contains(str1)) {
                count = 1;
                break;
            }
        }
        return count != 0 && checkCapital(password) && checkLower(password);
    }
    private boolean checkCapital(String password) {
        int count = 0;

        // checking capital letters
        for (int i = 65; i <= 90; i++) {

            char c = (char)i;

            String str1 = Character.toString(c);
            if (password.contains(str1)) {
                count = 1;
                break;
            }
        }
        return count != 0;
    }
    private boolean checkLower(String password) {
        int count = 0;

        // checking small letters
        for (int i = 97; i <= 122; i++) {

            char c = (char)i;
            String str1 = Character.toString(c);

            if (password.contains(str1)) {
                count = 1;
                break;
            }
        }
        return count != 0;
    }
}
