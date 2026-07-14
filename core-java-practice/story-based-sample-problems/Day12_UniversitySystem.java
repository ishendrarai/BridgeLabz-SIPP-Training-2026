public class Day12_UniversitySystem {
    static class Person {
        String name;
        int age;
        public Person(String name, int age) {
            this.name = name; this.age = age;
        }
        @Override
        public String toString() {
            return "Person [Name=" + name + ", Age=" + age + "]";
        }
    }
    
    static class Student extends Person {
        final String studentId;
        double gpa;
        public Student(String name, int age, String id, double gpa) {
            super(name, age);
            this.studentId = id;
            this.gpa = gpa;
        }
        @Override
        public String toString() {
            return "Student [ID=" + studentId + ", GPA=" + gpa + ", " + super.toString() + "]";
        }
    }
    
    static class GradStudent extends Student {
        String thesis;
        public GradStudent(String name, int age, String id, double gpa, String thesis) {
            super(name, age, id, gpa);
            this.thesis = thesis;
        }
        @Override
        public String toString() {
            return "GradStudent [Thesis=" + thesis + ", " + super.toString() + "]";
        }
    }
    
    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Alice", 24, "S101", 3.8, "Quantum Computing");
        System.out.println(gs.toString());
        
        System.out.println("IS-A Student: " + (gs instanceof Student));
        System.out.println("IS-A Person: " + (gs instanceof Person));
    }
}
