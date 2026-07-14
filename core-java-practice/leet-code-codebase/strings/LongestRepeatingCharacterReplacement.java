public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int l = 0, maxCount = 0, maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(r) - 'A']);
            if (r - l + 1 - maxCount > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
