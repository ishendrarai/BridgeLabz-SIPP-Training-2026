import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                if (curr >= n) curr /= 10;
                curr += 1;
                while (curr % 10 == 0) curr /= 10;
            }
        }
        return result;
    }
}
