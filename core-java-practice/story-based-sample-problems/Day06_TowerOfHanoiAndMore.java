public class Day06_TowerOfHanoiAndMore {
    public static int moves = 0;
    
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            moves++;
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        moves++;
        towerOfHanoi(n - 1, aux, to, from);
    }
    
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
        return binarySearch(arr, mid + 1, right, target);
    }
    
    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }
    
    public static String reverseString(String s) {
        if (s.isEmpty()) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    public static boolean checkBalanced(String s, int count) {
        if (s.isEmpty()) return count == 0;
        if (count < 0) return false;
        char c = s.charAt(0);
        if (c == '(') return checkBalanced(s.substring(1), count + 1);
        if (c == ')') return checkBalanced(s.substring(1), count - 1);
        return checkBalanced(s.substring(1), count);
    }
    
    public static void main(String[] args) {
        System.out.println("--- Tower of Hanoi (3 disks) ---");
        towerOfHanoi(3, 'A', 'C', 'B');
        System.out.println("Total moves: " + moves);
        
        System.out.println("\n--- Binary Search ---");
        int[] prices = {10, 20, 30, 40, 50, 60};
        System.out.println("Index of 40: " + binarySearch(prices, 0, prices.length - 1, 40));
        
        System.out.println("\n--- Sum of Digits ---");
        System.out.println("Sum of 12345: " + sumOfDigits(12345));
        
        System.out.println("\n--- Reverse String ---");
        System.out.println("Reverse of 'hello': " + reverseString("hello"));
        
        System.out.println("\n--- Check Balanced ---");
        System.out.println("Is '(())' balanced? " + checkBalanced("(())", 0));
        System.out.println("Is '(()' balanced? " + checkBalanced("(()", 0));
    }
}
