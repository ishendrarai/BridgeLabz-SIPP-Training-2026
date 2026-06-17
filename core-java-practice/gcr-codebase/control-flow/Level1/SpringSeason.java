import java.util.Scanner;

class SpringSeason {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the month: ");
        int month = input.nextInt();

        System.out.print("Enter the day: ");
        int day = input.nextInt();

        boolean isSpringSeason = (month == 3 && day >= 20) ||
                                 (month == 4) ||
                                 (month == 5) ||
                                 (month == 6 && day <= 20);

        if (isSpringSeason) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        input.close();
    }
}