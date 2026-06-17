import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter the height in cm: ");
        double height = input.nextDouble();

        double areaInSquareCentimeters = 0.5 * base * height;
        double areaInSquareInches = areaInSquareCentimeters / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " +
                           areaInSquareInches + " and sq cm is " +
                           areaInSquareCentimeters);

        input.close();
    }
}