import java.util.Scanner;

class VotingEligibilityArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] studentAges = new int[10];

        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = input.nextInt();
        }

        for (int i = 0; i < studentAges.length; i++) {

            if (studentAges[i] < 0) {
                System.out.println("The student with age " + studentAges[i] + " has invalid age.");
            } else if (studentAges[i] >= 18) {
                System.out.println("The student with age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with age " + studentAges[i] + " cannot vote.");
            }

        }

        input.close();
    }
}