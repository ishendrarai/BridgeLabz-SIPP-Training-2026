import java.io.*;
import java.util.Scanner;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_cards.txt";

        try (Scanner fileScanner = new Scanner(new File(inputFile));
             FileWriter fw = new FileWriter(outputFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int mark1 = Integer.parseInt(parts[1].trim());
                    int mark2 = Integer.parseInt(parts[2].trim());
                    int mark3 = Integer.parseInt(parts[3].trim());
                    double average = (mark1 + mark2 + mark3) / 3.0;

                    pw.printf("Name: %s | Marks: %d, %d, %d | Average: %.2f\n", name, mark1, mark2, mark3, average);
                }
            }
            System.out.println("Report cards generated successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file '" + inputFile + "' not found.");
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in input file.");
        }
    }
}
