import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String filename = "inventory.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String product = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());

                    if (quantity == 0) {
                        System.out.println(product + " is out of stock");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: inventory.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading inventory.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid quantity format in file.");
        }
    }
}
