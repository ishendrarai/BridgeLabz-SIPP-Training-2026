import java.util.Scanner;

public class FootballTeamHeight {
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) sum += h;
        return sum;
    }

    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int h : heights) {
            if (h < shortest) shortest = h;
        }
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int h : heights) {
            if (h > tallest) tallest = h;
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) {
            heights[i] = (int) (Math.random() * (250 - 150 + 1)) + 150;
        }

        System.out.println("Player Heights (cm): ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();

        System.out.println("Shortest: " + findShortest(heights) + " cm");
        System.out.println("Tallest: " + findTallest(heights) + " cm");
        System.out.printf("Mean: %.2f cm\n", findMean(heights));
    }
}
