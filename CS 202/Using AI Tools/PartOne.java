import java.math.BigInteger;

public class PartOne {
    public static int fibonacciOne(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer.");
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciOne(n - 1) + fibonacciOne(n - 2);
    }

    public static int fibonacciTwo(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer.");
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int a = 1, b = 1, fib = 1;
        for (int i = 3; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    public static int factorialOne(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer.");
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialTwo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer.");
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger factorialThree(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("n must be at least 2 since the smallest prime is 2.");
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            if (i % 2 == 0 && i != 2) {
                isPrime = false;
            } else {
                for (int j = 3; j * j <= i; j += 2) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }

        return result;
    }
}
