package org.ntnu.andershc.miniproject.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for PostalCode
 */
class PostalCodeTest {
    /**
     * Tests for the constructor.
     */
    @Nested
    public class ConstructorTests{
        /**
         * Tests for illegal postal code.
         */
        @Test
        public void postalCodeIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1", "test","test", "test", 't'));
        }
        /**
         * Tests for illegal postal name.
         */
        @Test
        public void postalNameNullPointerException(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("1111", "","test", "test", 't'));
        }
        /**
         * Tests for illegal municipal code.
         */
        @Test
        public void municipalCodeIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", 't'));
        }
        /**
         * Tests for illegal municipal name.
         */
        @Test
        public void municipalNameNullPointerException(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("test", "test","test", "", 't'));
        }
        /**
         * Tests for illegal category.
         */
        @Test
        public void categoryIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", '5'));
        }
    }

}