public class UniversitySystem {
    static class Person {
        public Person() {
        }
        @Override
        public String toString() {
            return "Person";
        }
    }

    static class Student extends Person {
        private final int studentId;

        public Student(int studentId) {
            super();
            this.studentId = studentId;
        }

        public int getStudentId() { return studentId; }

        @Override
        public String toString() {
            return super.toString() + " -> Student[ID: " + studentId + "]";
        }
    }

    static class GradStudent extends Student {
        private double gpa;
        private String thesis;

        public GradStudent(int studentId, double gpa, String thesis) {
            super(studentId);
            this.gpa = gpa;
            this.thesis = thesis;
        }

        @Override
        public String toString() {
            return super.toString() + " -> GradStudent[GPA: " + gpa + ", Thesis: '" + thesis + "']";
        }
    }

    public static void main(String[] args) {
        GradStudent grad = new GradStudent(101, 3.9, "AI in Robotics");
        System.out.println(grad.toString());
        
        System.out.println("grad IS-A Student: " + (grad instanceof Student));
        System.out.println("grad IS-A Person: " + (grad instanceof Person));
    }
}
