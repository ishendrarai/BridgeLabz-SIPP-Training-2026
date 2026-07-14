import java.util.Scanner;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] trigValues = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.4f\n", trigValues[0]);
        System.out.printf("Cosine: %.4f\n", trigValues[1]);
        System.out.printf("Tangent: %.4f\n", trigValues[2]);
        
        scanner.close();
    }
}
