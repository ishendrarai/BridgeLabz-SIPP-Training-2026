import java.util.Scanner;

public class FactorsAnalysis {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int productFactors(int[] factors) {
        int p = 1;
        for (int f : factors) p *= f;
        return p;
    }

    public static double productCubes(int[] factors) {
        double p = 1;
        for (int f : factors) {
            p *= Math.pow(f, 3);
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scanner.nextInt();

        int[] f = findFactors(num);
        System.out.println("Greatest factor: " + greatestFactor(f));
        System.out.println("Sum: " + sumFactors(f));
        System.out.println("Product: " + productFactors(f));
        System.out.println("Product of cubes: " + productCubes(f));
        
        scanner.close();
    }
}
