public class Triangles {

    /**
     * Indicates whether the lengths represent the sides of an equilateral triangle. An equilateral triangle has
     * equal lengths for all three sides.
     *
     * @param x the length of side x.
     * @param y the length of side y.
     * @param z the length of size z.
     *
     * @return true if the sides represent an equilateral triangle, otherwise, false.
     * @throws IllegalArgumentException if one or more lengths are less than 1, or the sides do not represent a valid
     * triangle.
     */
    public boolean isEquilateral(int x, int y, int z) {
        if(x < 1 || y < 1 || z < 1) {
            throw new IllegalArgumentException("Lengths must be greater than or equal to 1");
        }

        if(x >= y + z || y >= x + z || z >= x + y) {
            throw new IllegalArgumentException("All sides must satisfy the criteria: a < b + c");
        }

        return x == y && y == z;
    }

    /**
     * Indicates whether the lengths represent the sides of an isosceles triangle. An isosceles triangle has
     * equal lengths for exactly two sides.
     *
     * @param x the length of side x.
     * @param y the length of side y.
     * @param z the length of size z.
     *
     * @return true if the sides represent an isosceles triangle, otherwise, false.
     * @throws IllegalArgumentException if one or more lengths are less than 1, or the sides do not represent a valid
     * triangle.
     */
    public boolean isIsosceles(int x, int y, int z) {
        return !isEquilateral(x, y, z) && (x == y || x == z || y == z);
    }

    /**
     * Indicates whether the lengths represent the sides of a scalene triangle. A scalene triangle has
     * different lengths for all three sides.
     *
     * @param x the length of side x.
     * @param y the length of side y.
     * @param z the length of size z.
     *
     * @return true if the sides represent a scalene triangle, otherwise, false.
     * @throws IllegalArgumentException if one or more lengths are less than 1, or the sides do not represent a valid
     * triangle.
     */
    public boolean isScalene(int x, int y, int z) {
        return !isEquilateral(x, y, z) && !isIsosceles(x, y, z);
    }
}
