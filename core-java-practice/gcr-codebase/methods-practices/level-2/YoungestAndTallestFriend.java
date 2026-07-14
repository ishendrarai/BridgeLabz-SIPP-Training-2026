import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static String findYoungest(String[] names, int[] ages) {
        int minAge = ages[0];
        String youngest = names[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = names[i];
            }
        }
        return youngest;
    }

    public static String findTallest(String[] names, double[] heights) {
        double maxHeight = heights[0];
        String tallest = names[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = names[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height for " + friends[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        System.out.println("\nResults:");
        System.out.println("Youngest friend: " + findYoungest(friends, ages));
        System.out.println("Tallest friend: " + findTallest(friends, heights));
        
        scanner.close();
    }
}
