import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {
    public static abstract class CourseType {
        private String description;
        public CourseType(String desc) { this.description = desc; }
        public String getDescription() { return description; }
    }
    
    public static class ExamCourse extends CourseType {
        public ExamCourse() { super("Exam-Based"); }
    }
    
    public static class AssignmentCourse extends CourseType {
        public AssignmentCourse() { super("Assignment-Based"); }
    }
    
    public static class ResearchCourse extends CourseType {
        public ResearchCourse() { super("Research-Based"); }
    }
    
    public static class Course<T extends CourseType> {
        private String courseName;
        private T type;
        public Course(String name, T type) {
            this.courseName = name;
            this.type = type;
        }
        public String getCourseName() { return courseName; }
        public T getType() { return type; }
    }
    
    public static void displayCourses(List<? extends Course<?>> courses) {
        for (Course<?> course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getType().getDescription());
        }
    }
}
