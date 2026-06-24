import java.util.Scanner;

class StudentGradesArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("Student " + (i + 1));

            System.out.print("Enter Physics Marks: ");
            double physics = input.nextDouble();

            System.out.print("Enter Chemistry Marks: ");
            double chemistry = input.nextDouble();

            System.out.print("Enter Maths Marks: ");
            double maths = input.nextDouble();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("Invalid Marks. Enter Again.");
                i--;
                continue;
            }

            percentages[i] = (physics + chemistry + maths) / 3;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Percentage = " + percentages[i]);
            System.out.println("Grade = " + grades[i]);
        }

        input.close();
    }
}