import java.io.*;

public class GroceryBillReader {
    public static void main(String[] args) {
        String filename = "bill.txt";
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("--- Bill Contents ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("---------------------");
            System.out.println("Total lines in bill: " + lineCount);
        } catch (FileNotFoundException e) {
            System.err.println("Error: bill.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading bill.txt: " + e.getMessage());
        }
    }
}
