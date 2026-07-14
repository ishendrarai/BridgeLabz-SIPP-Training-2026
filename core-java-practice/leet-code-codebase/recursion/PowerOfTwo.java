public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        System.out.println("1 is power of 2? " + isPowerOfTwo(1));
        System.out.println("16 is power of 2? " + isPowerOfTwo(16));
        System.out.println("3 is power of 2? " + isPowerOfTwo(3));
    }
}
