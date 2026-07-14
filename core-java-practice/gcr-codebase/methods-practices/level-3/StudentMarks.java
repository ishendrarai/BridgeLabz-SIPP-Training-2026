import java.util.Scanner;

public class StudentMarks {
    public static int[][] generateMarks(int numStudents) {
        int[][] marks = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            marks[i][0] = (int) (Math.random() * 90) + 10;
            marks[i][1] = (int) (Math.random() * 90) + 10;
            marks[i][2] = (int) (Math.random() * 90) + 10;
        }
        return marks;
    }

    public static double[][] calculateStats(int[][] marks) {
        double[][] stats = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static void displayScorecard(int[][] marks, double[][] stats) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t%.2f%%\n", 
                i + 1, marks[i][0], marks[i][1], marks[i][2], 
                stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = sc.nextInt();

        int[][] marks = generateMarks(num);
        double[][] stats = calculateStats(marks);
        displayScorecard(marks, stats);

        sc.close();
    }
}
