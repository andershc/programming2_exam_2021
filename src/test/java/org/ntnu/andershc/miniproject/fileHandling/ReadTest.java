package org.ntnu.andershc.miniproject.fileHandling;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.ntnu.andershc.miniproject.model.PostalCodeRegister;

import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the read functionality.
 */
class ReadTest {
    /**
     * Tests for readFile().
     */
    @Nested
    public class readFileTests{
        /**
         * Positive test for the readFile method.
         * Uses a pre defined .txt file as test data:
         * src/main/resources/testData/testFile.txt¨.
         */
        @Test
        public void readFileTestPositive(){
            PostalCodeRegister register = new PostalCodeRegister();
            Read reader = new Read("src/main/resources/testData/testFile.txt");
            reader.readFile(register);
            assertEquals(2, register.getAllPostalCodes().size());
        }
        /**
         * Negative test for the readCSV method. takes in a non-.txt file.
         */
        @Test
        public void readFileTestNegative(){
            PostalCodeRegister register = new PostalCodeRegister();
            Read reader = new Read("NotAPath");
            assertThrows(IllegalArgumentException.class, () -> reader.readFile(register));
        }
    }
}
