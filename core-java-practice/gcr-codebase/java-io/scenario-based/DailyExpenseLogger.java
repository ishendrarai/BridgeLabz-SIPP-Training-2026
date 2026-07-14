import java.io.*;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "expenses.txt";

        System.out.print("Enter expense category (e.g., Food, Travel, Shopping): ");
        String category = sc.nextLine();
        
        System.out.print("Enter expense amount: ");
        double amount = sc.nextDouble();

        try (FileWriter fw = new FileWriter(filename, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            pw.printf("%s - %.0f\n", category, amount);
            System.out.println("Expense logged successfully.");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
