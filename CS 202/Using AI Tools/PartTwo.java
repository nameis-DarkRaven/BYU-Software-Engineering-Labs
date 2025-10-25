public class PartTwo {

    // Calculate the area of a circle
    // This function works correctly, but it can definitely be simplified.
    public static double calculateCircleArea(double r) {
        return Math.PI * r * r;
    }

    // Calculate the sum of a geometric series with given first term, ratio, and number of terms
    // There is a bug in the implementation of this function.
    public static double geometricSeriesSum(double firstTerm, double ratio, int numTerms) {
        if (ratio == 1) {
            return firstTerm * numTerms;
        }
        return firstTerm * (1 - Math.pow(ratio, numTerms)) / (1 - ratio);
    }

    // Calculate the value of the nth harmonic number
    // This function is accurate, but is very inefficient.
    public static double harmonicNumber(int n) {
        double sum = 0;
        double term = 1;
        for (int i = 1; i <= n; i++) {
            sum += term;
            term /= (i + 1);  // Update the term iteratively
        }
        return sum;
    }



}
