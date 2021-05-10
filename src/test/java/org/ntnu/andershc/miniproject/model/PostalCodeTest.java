package org.ntnu.andershc.miniproject.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for PostalCode
 */
public class PostalCodeTest {
    /**
     * Tests for the constructor.
     */
    @Nested
    public class ConstructorTests{
        /**
         * Tests for illegal postal code.
         */
        @Test
        public void postalCodeIllegalArgumentExceptionTest(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1", "test","test", "test", 't'));
        }
        /**
         * Tests for illegal postal name.
         */
        @Test
        public void postalNameNullPointerExceptionTest(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("1111", "","test", "test", 't'));
        }
        /**
         * Tests for illegal municipal code.
         */
        @Test
        public void municipalCodeIllegalArgumentExceptionTest(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", 't'));
        }
        /**
         * Tests for illegal municipal name.
         */
        @Test
        public void municipalNameNullPointerExceptionTest(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("test", "test","test", "", 't'));
        }
        /**
         * Tests for illegal category.
         */
        @Test
        public void categoryIllegalArgumentExceptionTest(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", '5'));
        }
    }

}