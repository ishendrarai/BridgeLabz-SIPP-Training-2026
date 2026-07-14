public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        System.out.println("16 is power of 4? " + isPowerOfFour(16));
        System.out.println("5 is power of 4? " + isPowerOfFour(5));
        System.out.println("1 is power of 4? " + isPowerOfFour(1));
    }
}
