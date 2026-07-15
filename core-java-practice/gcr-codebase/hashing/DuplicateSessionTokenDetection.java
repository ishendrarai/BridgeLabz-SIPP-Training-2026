import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionTokenDetection {
    public boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) { // add() returns false if already present
                return true;
            }
        }
        return false;
    }
}
