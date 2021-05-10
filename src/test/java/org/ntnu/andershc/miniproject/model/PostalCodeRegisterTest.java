package org.ntnu.andershc.miniproject.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.ntnu.andershc.miniproject.exceptions.AddException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for PostalCodeRegister.
 */
class PostalCodeRegisterTest {
    /**
     * Tests for addPostalCode().
     */
    @Nested
    public class AddPostalCode {
        /**
         * Positive test.
         * @throws AddException if the postal code already exists.
         */
        @Test
        public void addPostalCodePositive() throws AddException {
            PostalCodeRegister register = new PostalCodeRegister();
            String key = "1234";
            register.addPostalCode(key, "test", "5678", "test", "t");
            assertTrue(register.getAllPostalCodes().containsKey(key));
        }

        /**
         * Negative test.
         * @throws AddException if the postal code already exists.
         */
        @Test
        public void addPostalCodeNegative() throws AddException {
            PostalCodeRegister register = new PostalCodeRegister();
            String key = "1234";
            register.addPostalCode(key, "test", "5678", "test", "t");
            assertThrows(AddException.class,
                    () -> register.addPostalCode(key, "test", "5678", "test", "t"));
        }
    }
}