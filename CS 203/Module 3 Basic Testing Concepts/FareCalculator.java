public class FareCalculator {

    public static final int MAX_AGE = 116;
    public static final int MIN_HEIGHT = 12;

    public static final int CHILD_HEIGHT = 48;
    public static final int FREE_AGE = 1;
    public static final int SENIOR_AGE = 65;

    public static final float CHILD_FARE = 46.95f;
    public static final float ADULT_FARE = 64.95f;
    public static final float SENIOR_FARE = 58.95f;

    /**
     * Calculates admission fare based on the following ordered criteria:
     *
     * <ol>
     *     <li>Anyone under 2 years old is free</li>
     *     <li>Anyone under 48 inches tall and at least 2 years old pays the child fare<li/>
     *     <li>Anyone 48 inches tall or taller and age 65 or older, pays the senior fare</li>
     *     <li>Everyone else pays the adult fare</li>
     * <ol/>
     *
     * @param height the person's height in inches
     * @param age the person's age in years
     * @return the fare.
     * @throws IllegalArgumentException if age is less than 0 or greater than 116 or height is less than 12 inches.
     */
    public float calcuateFare(int height, int age) {
        if(age < 0 || age > MAX_AGE) {
            throw new IllegalArgumentException("Age must be between 0 and " + MAX_AGE);
        }

        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("Height must be at least " + MIN_HEIGHT + " inches");
        }

        float fare;
        if(age <= FREE_AGE) {
            fare = 0.0f;
        } else if(height < CHILD_HEIGHT) {
            fare = CHILD_FARE;
        } else if(age >= SENIOR_AGE) {
            fare = SENIOR_FARE;
        } else {
            fare = ADULT_FARE;
        }

        return fare;
    }
}
