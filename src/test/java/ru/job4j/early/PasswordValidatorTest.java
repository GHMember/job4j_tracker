package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @Test
    public void whenValidPassword() {
        String pass = "Test123!";
        assertThat(PasswordValidator.validate(pass)).isEqualTo("Password is valid");
    }

    @Test
    public void whenPasswordHasLessThenEightCharacters() {
        String pass = "Test12!";
        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password must contain from 8 to 32 characters");
    }

    @Test
    public void whenPasswordHasMoreThenThirtyTwoCharacters() {
        String pass = "Test1!Test1!Test1!Test1!Test1!Test1!";
        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password must contain from 8 to 32 characters");
    }

    @Test
    public void whenPasswordHasNotUpperCaseCharacter() {
        String pass = "test123!";
        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password must contain one uppercase letter the minimum");
    }

    @Test
    public void whenPasswordHasNotLowerCaseCharacter() {
        String pass = "TEST123!";
        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password must contain one lowercase letter the minimum");
    }

    @Test
    public void whenPasswordHasNotDigital() {
        String pass = "Testqwe!";
        assertThat(PasswordValidator.validate(pass)).isEqualTo("Password must contain one digit the minimum");
    }

    @Test
    public void whenPasswordHasNotSpecialCharacter() {
        String pass = "Test1234";
        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password must contain one special character the minimum");
    }

    @Test
    public void whenPasswordHasContainWrongSubstring() {
        String pass = "password";

        assertThat(PasswordValidator.validate(pass))
                .isEqualTo("Password mustn't contain substring like \"password\"");
    }
}