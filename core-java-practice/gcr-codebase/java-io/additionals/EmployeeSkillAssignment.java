import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String dept, double sal) {
        this.employeeId = id;
        this.name = name;
        this.department = dept;
        this.salary = sal;
    }

    @Override
    public String toString() {
        return "EmployeeId: " + employeeId + ", Name: " + name + 
               ", Department: " + department + ", Salary: " + salary;
    }
}

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "employee.ser";

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, dept, salary);

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(emp);
            System.out.println("Employee object serialized successfully.");
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Employee recoveredEmp = (Employee) ois.readObject();
            System.out.println("Recovered Employee Information:");
            System.out.println(recoveredEmp);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
        sc.close();
    }
}
