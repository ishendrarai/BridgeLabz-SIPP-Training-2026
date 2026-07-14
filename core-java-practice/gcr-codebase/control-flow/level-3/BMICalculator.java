import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in centimeters: ");
        double heightInCentimeters = input.nextDouble();

        double heightInMeters = heightInCentimeters / 100;

        double bmi = weight / (heightInMeters * heightInMeters);

        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("BMI = " + bmi);
        System.out.println("Weight Status = " + status);

        input.close();
    }
}