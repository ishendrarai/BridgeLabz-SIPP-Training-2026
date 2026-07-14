import java.util.Scanner;

class StudentGrade {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Physics Marks: ");
        double physicsMarks = input.nextDouble();

        System.out.print("Enter Chemistry Marks: ");
        double chemistryMarks = input.nextDouble();

        System.out.print("Enter Maths Marks: ");
        double mathsMarks = input.nextDouble();

        double averageMarks = (physicsMarks + chemistryMarks + mathsMarks) / 3;

        char grade;
        String remarks;

        if (averageMarks >= 80) {
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        } else if (averageMarks >= 70) {
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        } else if (averageMarks >= 60) {
            grade = 'C';
            remarks = "Level 2, below but approaching agency-normalized standards";
        } else if (averageMarks >= 50) {
            grade = 'D';
            remarks = "Level 1, well below agency-normalized standards";
        } else if (averageMarks >= 40) {
            grade = 'E';
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = 'R';
            remarks = "Remedial standards";
        }

        System.out.println("Average Marks = " + averageMarks);
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remarks);

        input.close();
    }
}