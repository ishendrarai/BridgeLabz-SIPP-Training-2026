import java.util.HashSet;
import java.util.Set;

public class EventEntryVerificationSystem {
    private Set<String> registeredEmails = new HashSet<>();
    
    public boolean register(String email) {
        return registeredEmails.add(email);
    }
    
    public void displayUniqueParticipants() {
        System.out.println("Total Eligible Attendees: " + registeredEmails.size());
        for (String email : registeredEmails) {
            System.out.println(email);
        }
    }
}
