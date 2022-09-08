package test;

import general.java.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {
    @Test
    public void whenPasswordIsNull() throws IllegalArgumentException {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Password is null.");
    }

    @Test
    public void whenLengthIsIncorrect() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("adads");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password length cannot be less than 8 or more than 32 characters.");
    }

    @Test
    public void whenUpperCaseIsMissing() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("sdsdasasaasdadadads");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain uppercase character.");
    }

    @Test
    public void whenLowerCaseIsMissing() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("AAAAAAASSSSSSS");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain lowercase character.");
    }

    @Test
    public void whenDigitIsMissing() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("AAAAasSSSSSSS");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain a digit.");
    }

    @Test
    public void whenSpecialCharIsMissing() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("AAAAas12aSSSSS");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain special character.");
    }

    @Test
    public void whenContentForbiddenValues() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("AUseras+12aSSSSS");
                });
        assertThat(exception.getMessage()).isEqualTo(
                "The password contains forbidden values.");
    }

    @Test
    public void whenPasswordCorrect() {
        String expected = "Pswr12+qw";
        String result = PasswordValidator.validate("Pswr12+qw");
        assertThat(result).isEqualTo(expected);
    }

}
