import java.io.*;
import java.util.*;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String filename = "emails.txt";
        List<String> domains = new ArrayList<>();
        Map<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String email;
            while ((email = br.readLine()) != null) {
                if (email.contains("@")) {
                    String domain = email.substring(email.indexOf("@") + 1);
                    domains.add(domain);
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }
            
            System.out.println("--- Domain Usage ---");
            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " users");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: emails.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading emails.txt: " + e.getMessage());
        }
    }
}
