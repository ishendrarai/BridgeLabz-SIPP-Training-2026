import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        String prev = "";
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!sortedWord.equals(prev)) {
                res.add(word);
                prev = sortedWord;
            }
        }
        return res;
    }
}
