public class UsernameValidator {
    public static boolean isValidUsername(String username, int index) {
        if (index == username.length()) return true;
        char ch = username.charAt(index);
        if (ch < 'a' || ch > 'z') return false;
        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        String user1 = "abcdxyz";
        System.out.println("Output: " + isValidUsername(user1, 0));

        String user2 = "abcD123";
        System.out.println("Output: " + isValidUsername(user2, 0));
    }
}
