public class CalculateFactorial {
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Input:\n" + n);
        System.out.println("Output:\n" + factorial(n));
    }
}
