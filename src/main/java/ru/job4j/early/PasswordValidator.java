package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be blank");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password must contain from 8 to 32 characters");
        }

        String passLC = password.toLowerCase();
        if (password.equals(passLC)) {
            throw new IllegalArgumentException("Password must contain one uppercase letter the minimum");
        }

        String passUC = password.toUpperCase();
        if (password.equals(passUC)) {
            throw new IllegalArgumentException("Password must contain one lowercase letter the minimum");
        }

        boolean containDigit = false;
        for (Character l : password.toCharArray()) {
            if (Character.isDigit(l)) {
                containDigit = true;
                break;
            }
        }
        if (!containDigit) {
            throw new IllegalArgumentException("Password must contain one digit the minimum");
        }

        boolean containSpecialChar = false;
        for (Character l : password.toCharArray()) {
            if (!Character.isLetter(l) && !Character.isDigit(l)) {
                containSpecialChar = true;
                break;
            }
        }
        if (!containSpecialChar) {
            throw new IllegalArgumentException("Password must contain one special character the minimum");
        }

        String[] wrongSubStrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String w : wrongSubStrings) {
            if (password.toLowerCase().contains(w)) {
                throw new IllegalArgumentException("Password mustn't contain substring like \"" + w + "\"");
            }
        }

        return password;
    }
}
