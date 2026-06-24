import java.util.Scanner;

class EmployeeBonusArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] salaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonusAmounts = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            salaries[i] = input.nextDouble();

            if (salaries[i] <= 0) {
                System.out.println("Invalid Salary. Enter Again.");
                i--;
                continue;
            }

            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            yearsOfService[i] = input.nextInt();
        }

        for (int i = 0; i < 10; i++) {

            if (yearsOfService[i] > 5) {
                bonusAmounts[i] = salaries[i] * 0.05;
            } else {
                bonusAmounts[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonusAmounts[i];

            totalBonus += bonusAmounts[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus Payout = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);

        input.close();
    }
}