import java.io.*;
import java.util.*;

public class Day09_StudentGradeManager {
    static class Student {
        String name;
        int[] marks = new int[5];
        int total;
        String grade;
        
        public void computeTotalAndGrade() {
            total = 0;
            for (int m : marks) total += m;
            double avg = total / 5.0;
            if (avg >= 90) grade = "A";
            else if (avg >= 80) grade = "B";
            else if (avg >= 70) grade = "C";
            else if (avg >= 60) grade = "D";
            else grade = "F";
        }
    }
    
    public static void main(String[] args) {
        String inputFile = "workshop1_input.txt";
        String outputFile = "workshop1_output.txt";
        
        // Setup input
        try (FileWriter fw = new FileWriter(inputFile)) {
            fw.write("Charlie,90,85,92,88,95\n");
            fw.write("Dave,60,65,70,68,62\n");
            fw.write("Eve,80,85,82,88,80\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<Student> students = new ArrayList<>();
        
        try (Scanner sc = new Scanner(new File(inputFile))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                Student s = new Student();
                s.name = parts[0];
                for (int i = 0; i < 5; i++) {
                    s.marks[i] = Integer.parseInt(parts[i+1]);
                }
                s.computeTotalAndGrade();
                students.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input not found.");
            return;
        }
        
        // Bubble sort by total marks (descending)
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).total < students.get(j+1).total) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                }
            }
        }
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            pw.println("--- Student Grade Report ---");
            for (Student s : students) {
                pw.println("Name: " + s.name + " | Total: " + s.total + " | Grade: " + s.grade);
            }
            System.out.println("Workshop 1 complete. Report saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
