import java.util.HashMap;
import java.util.Map;

public class MinimumCoverageWindow {
    public String minWindowSubstring(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        
        Map<Character, Integer> window = new HashMap<>();
        int required = need.size(), formed = 0;
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }
            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char leftChar = s.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
