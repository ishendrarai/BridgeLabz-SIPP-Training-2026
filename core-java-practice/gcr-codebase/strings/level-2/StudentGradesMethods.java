import java.util.Scanner;

public class StudentGradesMethods {
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // total, average, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];
            if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else if (percentage >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t");
            System.out.print(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "%\t\t");
            System.out.println(grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);

        displayScorecard(scores, stats, grades);

        input.close();
    }
}
