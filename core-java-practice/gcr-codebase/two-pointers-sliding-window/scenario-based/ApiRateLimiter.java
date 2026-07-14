import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiter {
    public int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0, maxLen = 0;
        for (int end = 0; end < keyIds.length; end++) {
            freq.put(keyIds[end], freq.getOrDefault(keyIds[end], 0) + 1);
            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);
                if (freq.get(leftKey) == 0) freq.remove(leftKey);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
