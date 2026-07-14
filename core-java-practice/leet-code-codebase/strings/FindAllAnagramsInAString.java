import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        if (matches(pCount, sCount)) res.add(0);
        
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (matches(pCount, sCount)) res.add(i - p.length() + 1);
        }
        
        return res;
    }
    
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) return false;
        }
        return true;
    }
}
