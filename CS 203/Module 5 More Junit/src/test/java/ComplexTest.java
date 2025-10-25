import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {
    Complex complex = new Complex();

    @Nested
    @DisplayName("Factorials")
    class factorialTests {
        @DisplayName("Correct Factorial Finding")
        @ParameterizedTest(name = "Factorial of {0}")
        @CsvSource({"0, 1", "1, 1", "5, 120", "10, 3628800"})
        void goodFactorial(long num, long factorial) {
            assertEquals(factorial, complex.factorial(num));
        }

        @DisplayName("No Factorials for Negatives")
        @Test
        void negativeFactorial() {
            assertThrows(ArithmeticException.class, () -> complex.factorial(-3));
        }
    }

    @Nested
    @DisplayName("Square Roots")
    class squareRootTests {

        @DisplayName("Good Square Roots")
        @ParameterizedTest(name = "Square Root of {0}")
        @CsvSource({"1, 1", "4, 2", "0, 0", "1.21, 1.1"})
        void goodSquareRoot(double num, double root) {
            assertEquals(root, complex.squareRoot(num));
        }

        @DisplayName("Negatives Have no Real Number Square Root")
        @Test
        void negativeSquareRoot() {
            assertEquals(Double.NaN, complex.squareRoot(-9.4));
        }

        @DisplayName("Positive Infinity")
        @Test
        void positiveInfinitySquareRoot(){
            assertEquals(Double.POSITIVE_INFINITY, complex.squareRoot(Double.POSITIVE_INFINITY));
        }
    }

    @Nested
    @DisplayName("Sine")
    class sineTests {

        @DisplayName("Good Sine Finding")
        @ParameterizedTest(name = "Sine of {0} degrees")
        @CsvSource({"45", "90", "125", "180", "200", "270", "285", "360", "-30", "37.5", "375", "800"})
        void goodSine(double degrees) {
            assertEquals(Math.sin(Math.toRadians(degrees)), complex.sin(degrees), 0.00001);

        }

        @DisplayName("Incorrect Sine Finding")
        @ParameterizedTest(name = "{0} is Not a Number")
        @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
        void badSine(Double num) {
            assertEquals(Double.NaN, complex.sin(num));
        }
    }
}