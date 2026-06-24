import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0.0;

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }

        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }

        double meanHeight = sum / heights.length;

        System.out.println("Mean Height of Football Team = " + meanHeight);

        input.close();
    }
}