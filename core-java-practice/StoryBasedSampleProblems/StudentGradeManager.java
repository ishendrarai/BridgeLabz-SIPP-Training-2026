import java.io.*;

public class StudentGradeManager {

    static String calculateGrade(double average) {

        if (average >= 90) {
            return "A";
        } else {
            if (average >= 75) {
                return "B";
            } else {
                if (average >= 60) {
                    return "C";
                } else {
                    return "D";
                }
            }
        }
    }

    static int searchStudent(String[] names, String target, int count) {

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                return i;
            }
        }

        return -1;
    }

    static void bubbleSort(String[] names,
                           double[] totals,
                           String[] grades,
                           int count) {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (totals[j] < totals[j + 1]) {

                    double tempTotal = totals[j];
                    totals[j] = totals[j + 1];
                    totals[j + 1] = tempTotal;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    String tempGrade = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrade;
                }
            }
        }
    }

    static void generateReport(String[] names,
                               double[] totals,
                               String[] grades,
                               int count) throws IOException {

        FileWriter fw = new FileWriter("reportcard.txt");

        for (int i = 0; i < count; i++) {

            fw.write("Name : " + names[i] + "\n");
            fw.write("Total Marks : " + totals[i] + "\n");
            fw.write("Grade : " + grades[i] + "\n");
            fw.write("-----------------------------\n");
        }

        fw.close();
    }

    public static void main(String[] args) {

        String[] names = new String[100];
        double[] totals = new double[100];
        String[] grades = new String[100];

        int count = 0;

        try {

            FileReader fr = new FileReader("students.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];

                int total = 0;

                for (int i = 1; i <= 5; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = total / 5.0;

                names[count] = name;
                totals[count] = total;
                grades[count] = calculateGrade(average);

                count++;
            }

            br.close();

            System.out.println("Student Details:");

            for (int i = 0; i < count; i++) {

                System.out.println(
                        names[i] + "  Total: "
                        + totals[i] + "  Grade: "
                        + grades[i]);
            }

            System.out.println();

            String searchName = "Rahul";

            int index = searchStudent(names, searchName, count);

            if (index != -1) {

                System.out.println("Student Found");
                System.out.println("Name : " + names[index]);
                System.out.println("Total : " + totals[index]);
                System.out.println("Grade : " + grades[index]);

            } else {

                System.out.println("Student Not Found");
            }

            bubbleSort(names, totals, grades, count);

            System.out.println("\nAfter Sorting:");

            for (int i = 0; i < count; i++) {

                System.out.println(
                        names[i] + "  Total: "
                        + totals[i] + "  Grade: "
                        + grades[i]);
            }

            generateReport(names, totals, grades, count);

            System.out.println("\nReport Generated Successfully");

        } catch (FileNotFoundException e) {

            System.out.println("students.txt file not found.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid marks format in file.");

        } catch (IOException e) {

            System.out.println("Error while processing file.");
        }
    }
}