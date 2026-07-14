import java.util.Scanner;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            System.out.println("Leap Year logic applies for year >= 1582.");
            return false;
        }
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (year >= 1582) {
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year");
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        } else {
            isLeapYear(year); // to trigger the warning message
        }

        scanner.close();
    }
}
