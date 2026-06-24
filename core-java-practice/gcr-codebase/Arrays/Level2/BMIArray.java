import java.util.Scanner;

class BMIArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int numberOfPersons = input.nextInt();

        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmiValues = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {

            System.out.print("Enter weight of person " + (i + 1) + ": ");
            weights[i] = input.nextDouble();

            System.out.print("Enter height in cm of person " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }

        for (int i = 0; i < numberOfPersons; i++) {

            double heightInMeters = heights[i] / 100;

            bmiValues[i] = weights[i] / (heightInMeters * heightInMeters);

            if (bmiValues[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmiValues[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmiValues[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < numberOfPersons; i++) {

            System.out.println("Person " + (i + 1));
            System.out.println("Height = " + heights[i] + " cm");
            System.out.println("Weight = " + weights[i] + " kg");
            System.out.println("BMI = " + bmiValues[i]);
            System.out.println("Status = " + weightStatus[i]);
        }

        input.close();
    }
}