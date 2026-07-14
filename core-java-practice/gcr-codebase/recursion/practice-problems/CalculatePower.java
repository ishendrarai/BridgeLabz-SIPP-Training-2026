public class CalculatePower {
    public static long power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println("Input:\nx = " + x + "\nn = " + n);
        System.out.println("Output:\n" + power(x, n));
    }
}
