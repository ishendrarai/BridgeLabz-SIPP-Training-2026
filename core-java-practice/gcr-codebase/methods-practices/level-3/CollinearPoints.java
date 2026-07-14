import java.util.Scanner;

public class CollinearPoints {
    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double m1 = (double) (y2 - y1) / (x2 - x1);
        double m2 = (double) (y3 - y2) / (x3 - x2);
        double m3 = (double) (y3 - y1) / (x3 - x1);
        return m1 == m2 && m2 == m3;
    }

    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x1, y1, x2, y2, x3, y3:");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        System.out.println("Collinear by slope: " + areCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by area: " + areCollinearArea(x1, y1, x2, y2, x3, y3));

        scanner.close();
    }
}
