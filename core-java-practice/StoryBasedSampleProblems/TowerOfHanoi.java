import java.util.Scanner;

public class TowerOfHanoi {

    static int moveCount = 0;

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {

        if (n == 1) {
            System.out.println("Move Disk 1 from " + source + " to " + destination);
            moveCount++;
            return;
        }

        towerOfHanoi(n - 1, source, destination, auxiliary);

        System.out.println("Move Disk " + n + " from " + source + " to " + destination);
        moveCount++;

        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearch(arr, low, mid - 1, target);
        }

        return binarySearch(arr, mid + 1, high, target);
    }

    public static int sumOfDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }

    public static String reverseString(String str) {

        if (str.length() <= 1) {
            return str;
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static boolean isBalanced(String str, int count, int index) {

        if (count < 0) {
            return false;
        }

        if (index == str.length()) {
            return count == 0;
        }

        if (str.charAt(index) == '(') {
            return isBalanced(str, count + 1, index + 1);
        }

        if (str.charAt(index) == ')') {
            return isBalanced(str, count - 1, index + 1);
        }

        return isBalanced(str, count, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks:- ");
        int disks = sc.nextInt();

        System.out.println("Tower of Hanoi Steps:");
        towerOfHanoi(disks, 'A', 'B', 'C');
        System.out.println("Total Moves:- " + moveCount);

        int[] priceList = {10, 20, 30, 40, 50, 60, 70, 80};

        System.out.print("\nEnter value to search:- ");
        int target = sc.nextInt();

        int result = binarySearch(priceList, 0, priceList.length - 1, target);

        if (result != -1) {
            System.out.println("Found at index:- " + result);
        } else {
            System.out.println("Not Found");
        }

        System.out.print("\nEnter a number:- ");
        int number = sc.nextInt();

        System.out.println("Sum of Digits:- " + sumOfDigits(number));

        sc.nextLine();

        System.out.print("\nEnter a string:- ");
        String text = sc.nextLine();

        System.out.println("Reversed String:- " + reverseString(text));

        System.out.print("\nEnter parentheses string:- ");
        String brackets = sc.nextLine();

        if (isBalanced(brackets, 0, 0)) {
            System.out.println("Balanced Parentheses");
        } else {
            System.out.println("Not Balanced");
        }

        sc.close();
    }
}