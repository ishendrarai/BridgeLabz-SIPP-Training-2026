import java.util.Scanner;

public class TriangularPark {
    public static double computeRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double targetDistance = 5000; // 5 km in meters
        return targetDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = scanner.nextDouble();

        double rounds = computeRounds(side1, side2, side3);
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds to run 5 km.");
        
        scanner.close();
    }
}
