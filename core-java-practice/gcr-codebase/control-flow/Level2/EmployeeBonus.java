import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();

        double bonusAmount = 0;

        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
        }

        System.out.println("The bonus amount is INR " + bonusAmount);

        input.close();
    }
}