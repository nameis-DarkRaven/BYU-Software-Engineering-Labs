import java.lang.ArithmeticException;


/**
 *
 * This is a Student class that represents a student in a college's student database.
 *
 * @author John Paul Andersen
 *
 * @version 1.0
 *
 */
public class Student {
    /**
     * A string containing a student's full name
     */
    public String name = "";

    /**
     * An integer containing a student's BYU ID
     */
    public int studentID = 0;

    /**
     * A double containing a student's GPA on a 4.0 scale.
     */
    public double GPA = 1.0;


    /**
     *
     * @param name The student's name
     * @param studentID The student's student ID
     * @param GPA The student's GPA
     */
    public Student(String name, int studentID, double GPA) {
        this.name = name;
        this.studentID = studentID;
        this.GPA = GPA;
    }

    /**
     * The calculateGPA method takes a student's total number of credits earned
     * and their points received and calculates the GPA
     *
     * @param numberOfCredits The number of credits a student has taken
     * @param rawPoints The number of quality points the student received
     *
     * @return the student's GPA
     * @throws ArithmeticException if rawPoints is 0
     */
    public double calculateGPA(double numberOfCredits, double rawPoints) throws ArithmeticException {
        if (rawPoints == 0.0) {
            throw new ArithmeticException("Error: divide by zero!");
        }

        return numberOfCredits / rawPoints;
    }

    /**
     * The isStudentFailing method checks the student's GPA to see if they are failing.
     *
     * @return Returns true if the GPA is less than or equal to 2.0 and false otherwise
     */
    public boolean isStudentFailing() {
        if (GPA <= 2.0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * The sendStudentAnEmail sends an email to the student.
     */
    public void sendStudentAnEmail() {
        //Code for sending an email
    }

}