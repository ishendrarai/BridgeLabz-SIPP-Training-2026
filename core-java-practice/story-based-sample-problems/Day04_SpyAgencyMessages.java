import java.util.Arrays;

public class Day04_SpyAgencyMessages {
    public static void main(String[] args) {
        String secret = "racecar";
        
        // Reverse
        StringBuilder sb = new StringBuilder(secret);
        String reversed = sb.reverse().toString();
        System.out.println("Original: " + secret + " | Reversed: " + reversed);
        
        // Palindrome check
        boolean isPal = secret.equals(reversed);
        System.out.println("Is Palindrome: " + isPal);
        
        // Count vowels/consonants
        int vowels = 0, cons = 0;
        for (char c : secret.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowels++;
            else if (Character.isLetter(c)) cons++;
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + cons);
        
        // Anagram verify
        String msg1 = "listen", msg2 = "silent";
        char[] arr1 = msg1.toCharArray();
        char[] arr2 = msg2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean isAnagram = Arrays.equals(arr1, arr2);
        System.out.println("Are '" + msg1 + "' and '" + msg2 + "' anagrams? " + isAnagram);
        
        // First non-repeating char
        String log = "surveillance";
        int[] freq = new int[256];
        for (char c : log.toCharArray()) freq[c]++;
        char firstNon = '-';
        for (char c : log.toCharArray()) {
            if (freq[c] == 1) {
                firstNon = c;
                break;
            }
        }
        System.out.println("First non-repeating char in '" + log + "': " + firstNon);
    }
}
