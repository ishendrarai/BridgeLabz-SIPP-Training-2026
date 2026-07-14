public class SumOfNaturalNumbers {
    public static int sum(int n) {
        if (n <= 0) return 0;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Input:\nN = " + n);
        System.out.println("Output:\n" + sum(n));
    }
}
