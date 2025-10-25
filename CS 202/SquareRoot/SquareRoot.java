public class SquareRoot {

    public static void main(String args[]) {
        if (args.length == 0){
            System.out.println("Usage: SqareRoot number_to_calculate");
            return;
        }
//        System.out.println(args.length);
        String numberString = args[0];

        double number = Double.parseDouble(numberString);
        number = Math.abs(number);   //Force to be non-negative

        double low, high, middle, oldMiddle, middleSquared;
        int step = 0;

        // Set initial bounds
        low = 0;
        high = number;
        middle = number;
        oldMiddle = -1;

        // Keep going until accurate enough.
        while (Math.abs(oldMiddle - middle) >= 0.000001) {
            oldMiddle = middle;

            // Get midpoint and see if we need lower or higher.
            middle = (high + low) / 2;
            middleSquared = middle * middle;

            if (middleSquared > number) {
                high = middle;
            } else {
                low = middle;
            }

            step++;
//            System.out.println(step);
//            System.out.printf("Iteration: %d\n", step);
//            System.out.printf("oldMiddle: %f\n", oldMiddle);
//            System.out.printf("currentMiddle: %f\n", middle);
//            System.out.printf("middleSquared: %f\n", middleSquared);
//            System.out.printf("low: %f\n", low);
//            System.out.printf("high: %f\n\n", high);

        }

        // Desired accuracy reached, print it.

        System.out.printf("Number of iterations: %d\n", step);
        System.out.printf("sqrt(%.4f) = %.4f\n", number, middle);
    }
}