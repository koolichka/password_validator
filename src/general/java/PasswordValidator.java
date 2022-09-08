package general.java;

public class PasswordValidator {
    public static String validate(String password) {

        boolean hasDigit = false;
        boolean hasLetterOrDigit = false;
        boolean forbiddenValues = true;
        String[] invalidPassword = {"qwerty", "12345", "password", "admin", "user"};

        if (password == null) {
            throw new IllegalArgumentException("Password is null.");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "The password length cannot be less than 8 or more than 32 characters.");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException(
                    "The password must contain uppercase character.");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException(
                    "The password must contain lowercase character.");
        }
        for (String pass : invalidPassword) {
            if (password.toLowerCase().contains(pass.toLowerCase())) {
                forbiddenValues = false;
                break;
            }
        }
        for (int index = 0; index < password.length(); index++) {
            char ch = password.charAt(index);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                hasLetterOrDigit = true;
            }
            if (hasDigit && hasLetterOrDigit) {
                break;
            }
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "The password must contain a digit.");
        }
        if (!hasLetterOrDigit) {
            throw new IllegalArgumentException(
                    "The password must contain special character.");
        }
        if (!forbiddenValues) {
            throw new IllegalArgumentException(
                    "The password contains forbidden values.");
        }
        return password;
    }
}
