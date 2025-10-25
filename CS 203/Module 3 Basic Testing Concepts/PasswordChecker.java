public class PasswordChecker {

    private static final int MIN_SIZE = 8;
    private static final int MAX_SIZE = 20;
    private static final char [] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*' };

    /**
     * Verifies the validity of a password according. Valid passwords must meet the following criteria:
     *
     * <ul>
     *     <li>Between 8 and 20 characters</li>
     *     <li>Contains only alphabetic letters, digits, and the following special characters: !@#$%^&*</li>
     *     <li>Contains at least one digit</li>
     *     <li>Contains at least one upper case letter</li>
     *     <li>Contains at least one lower case letter</li>
     *     <li>Contains at least one special character</li>
     * </ul>
     * @param password
     * @return
     */
    public boolean isPasswordValid(String password) {

        boolean containsDigit = false;
        boolean containsUpperCaseLetter = false;
        boolean containsLowerCaseLetter = false;
        boolean containsSpecialCharacter = false;

        if(password.length() < MIN_SIZE || password.length() > MAX_SIZE) {
            return false;
        } else {
            for(char c : password.toCharArray()) {
                if(Character.isDigit(c)) {
                    containsDigit = true;
                } else if(Character.isLetter(c) && Character.isUpperCase(c)) {
                    containsUpperCaseLetter = true;
                } else if(Character.isLetter(c) && Character.isLowerCase(c)) {
                    containsLowerCaseLetter = true;
                } else if(isSpecialChar(c)){
                    containsSpecialCharacter = true;
                }
            }

            return containsDigit && containsUpperCaseLetter && containsLowerCaseLetter && containsSpecialCharacter;
        }
    }

    private boolean isSpecialChar(char c) {
        for(char specialChar : specialChars) {
            if(c == specialChar) {
                return true;
            }
        }

        return false;
    }
}
