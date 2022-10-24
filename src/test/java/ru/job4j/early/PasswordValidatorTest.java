package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest {

    @Test
    public void whenValidPassword() {
        String pass = "Test123!";
        assertThat(PasswordValidator.validate(pass)).isEqualTo("Test123!");
    }

    @Test
    public void whenPasswordHasLessThenEightCharacters() {
        try {
            PasswordValidator.validate("Test1!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain from 8 to 32 characters");
        }
    }

    @Test
    public void whenPasswordHasMoreThenThirtyTwoCharacters() {
        try {
            PasswordValidator.validate("Test1!Test1!Test1!Test1!Test1!Test1!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain from 8 to 32 characters");
        }
    }

    @Test
    public void whenPasswordHasNotUpperCaseCharacter() {
        try {
            PasswordValidator.validate("test123!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain one uppercase letter the minimum");
        }
    }

    @Test
    public void whenPasswordHasNotLowerCaseCharacter() {
        try {
            PasswordValidator.validate("TEST123!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain one lowercase letter the minimum");
        }
    }

    @Test
    public void whenPasswordHasNotDigital() {
        try {
            PasswordValidator.validate("Testqwe!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain one digit the minimum");
        }
    }

    @Test
    public void whenPasswordHasNotSpecialCharacter() {
        try {
            PasswordValidator.validate("Test1234");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password must contain one special character the minimum");
        }
    }

    @Test
    public void whenPasswordHasContainWrongSubstring() {
        try {
            PasswordValidator.validate("MyPasWorD1!");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Password mustn't contain substring like \"password\"");
        }
    }
}