import java.util.Scanner;

public class ZaraBonus {
    public static double[][] calculateSalaryAndBonus(int numEmployees) {
        double[][] data = new double[numEmployees][4];
        for (int i = 0; i < numEmployees; i++) {
            double salary = (Math.random() * 90000) + 10000;
            double years = Math.random() * 10;
            data[i][0] = salary;
            data[i][1] = years;
            
            double bonusPercentage = years > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusPercentage;
            
            data[i][2] = bonus;
            data[i][3] = salary + bonus;
        }
        return data;
    }

    public static void displaySummary(double[][] data) {
        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;
        
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        for (int i = 0; i < data.length; i++) {
            totalOldSalary += data[i][0];
            totalBonus += data[i][2];
            totalNewSalary += data[i][3];
            System.out.printf("%d\t%.2f\t%.1f\t%.2f\t\t%.2f\n", 
                i + 1, data[i][0], data[i][1], data[i][2], data[i][3]);
        }
        
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Total\t%.2f\t\t%.2f\t\t%.2f\n", totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int num = scanner.nextInt();

        double[][] data = calculateSalaryAndBonus(num);
        displaySummary(data);

        scanner.close();
    }
}
