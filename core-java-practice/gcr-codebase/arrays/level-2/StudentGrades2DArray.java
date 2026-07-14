import java.util.Scanner;

class StudentGrades2DArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("Student " + (i + 1));

            System.out.print("Enter Physics Marks: ");
            marks[i][0] = input.nextDouble();

            System.out.print("Enter Chemistry Marks: ");
            marks[i][1] = input.nextDouble();

            System.out.print("Enter Maths Marks: ");
            marks[i][2] = input.nextDouble();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid Marks. Enter Again.");
                i--;
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

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
            System.out.println("Physics = " + marks[i][0]);
            System.out.println("Chemistry = " + marks[i][1]);
            System.out.println("Maths = " + marks[i][2]);
            System.out.println("Percentage = " + percentages[i]);
            System.out.println("Grade = " + grades[i]);
        }

        input.close();
    }
}