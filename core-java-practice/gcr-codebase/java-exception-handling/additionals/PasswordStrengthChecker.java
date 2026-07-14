public class PasswordStrengthChecker {
    public static void checkPassword(String password) {
        try {
            if (password == null) {
                throw new NullPointerException("Password cannot be null.");
            }
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty.");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters long.");
            }
            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("First character must be uppercase.");
            }
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Last character must be a digit.");
            }
            if (!password.matches(".*[@#$%&*].*")) {
                throw new IllegalArgumentException("Password must contain at least one special character (@, #, $, %, &, *).");
            }
            System.out.println("Password is valid and strong.");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] testPasswords = {
            "", 
            "Short1", 
            "NoSpecialChar1", 
            "lowercaseFirst@1", 
            "NoDigitLast@", 
            null, 
            "ValidPassword@1"
        };

        for (String p : testPasswords) {
            System.out.println("\nChecking password: " + p);
            checkPassword(p);
        }
    }
}
