public class NumberChecker {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int temp = Math.abs(number);
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, digits.length);
        }
        return sum == number;
    }

    public static boolean isHarshadNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int d : digits) sum += d;
        return number % sum == 0;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }

    public static boolean isPalindrome(int[] original, int[] reversed) {
        if (original.length != reversed.length) return false;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpyNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = 0, product = 1;
        for (int d : digits) {
            sum += d;
            product *= d;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        String strNum = String.valueOf(number);
        String strSq = String.valueOf(square);
        return strSq.endsWith(strNum);
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) return false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        if (number <= 0) return false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        if (number <= 0) return false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int d : digits) {
            sum += factorial(d);
        }
        return sum == number;
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
