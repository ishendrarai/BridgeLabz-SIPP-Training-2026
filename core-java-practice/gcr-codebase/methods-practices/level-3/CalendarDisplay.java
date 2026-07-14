import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] m = {"", "January", "February", "March", "April", "May", "June", 
                      "July", "August", "September", "October", "November", "December"};
        return m[month];
    }

    public static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) return 29;
        return d[month];
    }

    public static int getFirstDay(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();

        System.out.println(getMonthName(m) + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirstDay(m, y);
        int days = getDaysInMonth(m, y);

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= days; i++) {
            System.out.printf("%3d ", i);
            if ((i + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
        sc.close();
    }
}
