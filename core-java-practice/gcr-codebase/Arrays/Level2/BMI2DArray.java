import java.util.Scanner;

class BMI2DArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {

            System.out.print("Enter weight of person " + (i + 1) + ": ");
            double weight = input.nextDouble();

            System.out.print("Enter height in cm of person " + (i + 1) + ": ");
            double height = input.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Please enter positive values.");
                i--;
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;
        }

        for (int i = 0; i < number; i++) {

            double heightInMeters = personData[i][1] / 100;

            personData[i][2] = personData[i][0] / (heightInMeters * heightInMeters);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < number; i++) {

            System.out.println("Person " + (i + 1));
            System.out.println("Weight = " + personData[i][0] + " kg");
            System.out.println("Height = " + personData[i][1] + " cm");
            System.out.println("BMI = " + personData[i][2]);
            System.out.println("Status = " + weightStatus[i]);
        }

        input.close();
    }
}