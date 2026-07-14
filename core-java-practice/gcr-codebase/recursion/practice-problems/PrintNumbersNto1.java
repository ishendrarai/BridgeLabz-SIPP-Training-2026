public class PrintNumbersNto1 {
    public static void printNumbers(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Output:");
        printNumbers(n);
    }
}
