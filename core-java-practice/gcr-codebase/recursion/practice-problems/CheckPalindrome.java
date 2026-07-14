public class CheckPalindrome {
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Input:\n" + input);
        
        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("Output:\nPalindrome");
        } else {
            System.out.println("Output:\nNot a Palindrome");
        }
    }
}
