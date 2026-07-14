import java.io.*;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        String filename = "feedback.txt";
        int goodCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int linesRead = 0;
            while ((line = br.readLine()) != null && linesRead < 5) {
                if (line.toLowerCase().contains("good")) {
                    goodCount++;
                }
                linesRead++;
            }
            System.out.println("Good Feedback Count = " + goodCount);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Feedback file not found.");
        } catch (IOException e) {
            System.err.println("Error reading feedback file: " + e.getMessage());
        }
    }
}
