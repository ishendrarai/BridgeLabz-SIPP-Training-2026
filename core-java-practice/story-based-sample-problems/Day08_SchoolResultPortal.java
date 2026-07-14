import java.io.*;
import java.util.Scanner;

public class Day08_SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_cards.txt";
        
        // Let's create dummy input file first
        try (FileWriter fw = new FileWriter(inputFile)) {
            fw.write("Alice,85,90,88\n");
            fw.write("Bob,75,80,72\n");
        } catch (IOException e) {
            System.out.println("Could not setup input file.");
        }
        
        System.out.println("--- Generating Report Cards ---");
        try (Scanner sc = new Scanner(new File(inputFile));
             FileWriter fw = new FileWriter(outputFile, true); // true for append mode
             BufferedWriter bw = new BufferedWriter(fw)) {
             
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int m1 = Integer.parseInt(parts[1]);
                int m2 = Integer.parseInt(parts[2]);
                int m3 = Integer.parseInt(parts[3]);
                double avg = (m1 + m2 + m3) / 3.0;
                
                String report = "Student: " + name + " | Average: " + String.format("%.2f", avg);
                System.out.println(report);
                bw.write(report);
                bw.newLine();
            }
            System.out.println("Report cards appended successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found gracefully handled.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
