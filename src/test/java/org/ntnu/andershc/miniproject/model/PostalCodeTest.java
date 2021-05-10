package org.ntnu.andershc.miniproject.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostalCodeTest {
    @Nested
    public class ConstructorTests{
        @Test
        public void postalCodeIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1", "test","test", "test", 't'));
        }
        @Test
        public void postalNameNullPointerException(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("1111", "","test", "test", 't'));
        }
        @Test
        public void municipalCodeIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", 't'));
        }
        @Test
        public void municipalNameNullPointerException(){
            assertThrows(NullPointerException.class, () ->
                    new PostalCode("test", "test","test", "", 't'));
        }
        @Test
        public void categoryIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () ->
                    new PostalCode("1111", "test","1", "test", '5'));
        }
    }

}