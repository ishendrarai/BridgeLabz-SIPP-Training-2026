import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        try {

            FileReader fr = new FileReader("students.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("reportcard.txt", true);

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];

                int mark1 = Integer.parseInt(data[1]);
                int mark2 = Integer.parseInt(data[2]);
                int mark3 = Integer.parseInt(data[3]);

                double average = (mark1 + mark2 + mark3) / 3.0;

                fw.write("Student Name : " + name + "\n");
                fw.write("Average Marks : " + average + "\n");

                if (average >= 90) {
                    fw.write("Grade : A\n");
                } else if (average >= 75) {
                    fw.write("Grade : B\n");
                } else {
                    fw.write("Grade : C\n");
                }

                fw.write("-------------------------\n");
            }

            br.close();
            fw.close();

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("Error: students.txt file not found.");

        } catch (IOException e) {

            System.out.println("Error while reading or writing file.");
        }
    }
}