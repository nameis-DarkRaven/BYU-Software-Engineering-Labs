public class PartThree {
    // Use ChatGPT on these functions to explain what they do and to refactor them to make them more readable through
    // the use better variable and function names.  Explain what each one does in a brief comment before the function.

    // This function finds the nth prime.
    public static int findNthPrime(int n) {
        int primesFound = 0;
        int nthPrime = 2;
        while (primesFound < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(nthPrime); i++) {
                if (nthPrime % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primesFound++;
            }
            nthPrime++;
        }
        return nthPrime - 1;
    }

    // This function computes pi using the Leibniz series using n terms,
    // the larger the n, the more precise the answer.
    public static double Leibniz(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(-1, i) / (2 * i + 1);
        }
        return 4 * sum;
    }

    // This function uses Heron's formula to compute the area of a triangle given three sides,
    // assuming that the three sides actually form a triangle.
    public static double findTriangleArea(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }


}
