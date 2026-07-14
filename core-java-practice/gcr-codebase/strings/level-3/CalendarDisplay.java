import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", 
                           "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    public static int getFirstDayOfMonth(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;
        return d0;
    }

    public static void printCalendar(int month, int year) {
        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDayOfMonth(month, year);
        int daysInMonth = getDaysInMonth(month, year);

        for (int i = 0; i < startDay; i++) {
            System.out.print("    "); // 4 spaces
        }

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();

        printCalendar(month, year);
        input.close();
    }
}
