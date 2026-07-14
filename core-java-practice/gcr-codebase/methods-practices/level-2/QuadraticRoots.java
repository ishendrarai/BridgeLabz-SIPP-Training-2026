import java.util.Scanner;

public class QuadraticRoots {
    public static void findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Roots are: " + root1 + " and " + root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is: " + root);
        } else {
            System.out.println("No real roots.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        findRoots(a, b, c);
        
        scanner.close();
    }
}
