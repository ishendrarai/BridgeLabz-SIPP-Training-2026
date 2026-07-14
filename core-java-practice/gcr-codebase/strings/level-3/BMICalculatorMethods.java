import java.util.Scanner;

public class BMICalculatorMethods {
    public static String[][] computeBMIAndStatus(double[][] personData) {
        String[][] results = new String[personData.length][4];
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightInCm = personData[i][1];
            double heightInM = heightInCm / 100.0;
            
            double bmi = weight / (heightInM * heightInM);
            String status;

            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            results[i][0] = String.valueOf(heightInCm);
            results[i][1] = String.valueOf(weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }
        return results;
    }

    public static void displayBMIStatus(String[][] results) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t\t" + results[i][1] + "\t\t" + results[i][2] + "\t" + results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int numPersons = input.nextInt();

        double[][] personData = new double[numPersons][2];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Weight (kg): ");
            personData[i][0] = input.nextDouble();
            System.out.print("Height (cm): ");
            personData[i][1] = input.nextDouble();
        }

        String[][] results = computeBMIAndStatus(personData);
        displayBMIStatus(results);

        input.close();
    }
}
