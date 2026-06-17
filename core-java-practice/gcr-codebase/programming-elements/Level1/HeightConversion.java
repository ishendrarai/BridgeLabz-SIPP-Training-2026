import java.util.Scanner;

class HeightConversion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        double heightInCentimeters = input.nextDouble();

        double totalInches = heightInCentimeters / 2.54;
        int heightInFeet = (int)(totalInches / 12);
        double remainingInches = totalInches % 12;

        System.out.println("Your Height in cm is " + heightInCentimeters +
                           " while in feet is " + heightInFeet +
                           " and inches is " + remainingInches);

        input.close();
    }
}