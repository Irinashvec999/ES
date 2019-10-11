package ua.kiev.appliances.service;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class PasswordEncoderImplTest {
    PasswordEncoderImpl passwordEncoder = new PasswordEncoderImpl();

    @Test
    public void encodedPasswordNotEqualsPassword() {
        String actual = "UserPassword";
        String expected = passwordEncoder.encode(actual);
        assertNotEquals(expected, actual);
    }

    @Test
    public void encodedPasswordMatchesPassword() {
        String actual = "UserPassword";
        String expected = passwordEncoder.encode(actual);
        assertTrue(passwordEncoder.matches(actual, expected));
    }
}