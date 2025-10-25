package edu.byu.cs203.junit.advanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {
    Simple simple = new Simple();

    @DisplayName("Addition")
    @ParameterizedTest(name = "Add {0} and {1}")
    @CsvSource({"13, 21, 34", "-1, -6, -7", "13, -5, 8"})
    void goodAdd(int num1, int num2, int sum) {
        assertEquals(sum, simple.add(num1, num2));
    }


    @DisplayName("Subtraction")
    @ParameterizedTest(name = "Subtract {1} from {0}")
    @CsvSource({"13, 21, -8", "-1, -6, 5", "13, -5, 18", "12, 4, 8"})
    void goodSubtract(int num1, int num2, int difference) {
        assertEquals(difference, simple.subtract(num1, num2));
    }

    @DisplayName("Multiplication")
    @ParameterizedTest(name = "Multiply {0} and {1}")
    @CsvSource({"1, 2, 2", "-3, -6, 18", "3, -5, -15", "12, 0, 0", "11, 12, 132"})
    void goodMultiply(int num1, int num2, int product) {
        assertEquals(product, simple.multiply(num1, num2));
    }

    @Nested
    @DisplayName("Division")
    class divisionTests {
        @DisplayName("Good Division")
        @ParameterizedTest(name = "Divide {0} by {1}")
        @CsvSource({"12, 2, 6", "-36, -4, 9", "-42, 7, -6", "14, -7, -2"})
        void goodDivide(int num1, int num2, int quotient) {
            assertEquals(quotient, simple.divide(num1, num2));
        }

        @DisplayName("Cannot Divide By Zero")
        @Test
        void divideByZero() {
            assertThrows(ArithmeticException.class, () -> simple.divide(42, 0));
        }
    }


    @DisplayName("Exponentiation")
    @ParameterizedTest(name = "Take {0} to the power of {1}")
    @CsvSource({"1, 2, 1", "0, 12, 0", "15, 0, 1", "2, 6, 64"})
    void goodPower(int num1, int num2, int power) {
        assertEquals(power, simple.power(num1, num2));
    }
}