package org.ntnu.andershc.miniproject.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.ntnu.andershc.miniproject.exceptions.AddException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for PostalCodeRegister.
 */
public class PostalCodeRegisterTest {
    /**
     * Tests for addPostalCode().
     */
    @Nested
    public class AddPostalCodeTest {
        /**
         * Positive test.
         * @throws AddException if the postal code already exists.
         */
        @Test
        public void addPostalCodeTestPositive() throws AddException {
            PostalCodeRegister register = new PostalCodeRegister();
            String key = "1234";
            register.addPostalCode(key, "test", "5678", "test", "t");
            assertTrue(register.getAllPostalCodes().containsKey(key));
        }

        /**
         * Negative test for illegal input
         * @throws AddException if the postal code already exists.
         */
        @Test
        public void addPostalCodeTestIllegalInput() throws AddException {
            PostalCodeRegister register = new PostalCodeRegister();
            String key = "12346";
            register.addPostalCode(key, "test", "5678", "test", "t");
            assertFalse(register.getAllPostalCodes().containsKey(key));
        }

        /**
         * Negative test for when the postal code is already registered.
         * @throws AddException if the postal code already exists.
         */
        @Test
        public void addPostalCodeTestAlreadyInRegister() throws AddException {
            PostalCodeRegister register = new PostalCodeRegister();
            String key = "1234";
            register.addPostalCode(key, "test", "5678", "test", "t");
            assertThrows(AddException.class,
                    () -> register.addPostalCode(key, "test", "5678", "test", "t"));
        }
    }
}