import java.util.List;

public class AiDrivenResumeScreening {
    public static abstract class JobRole {
        private String roleName;
        public JobRole(String name) { this.roleName = name; }
        public String getRoleName() { return roleName; }
    }
    
    public static class SoftwareEngineer extends JobRole {
        public SoftwareEngineer() { super("Software Engineer"); }
    }
    
    public static class DataScientist extends JobRole {
        public DataScientist() { super("Data Scientist"); }
    }
    
    public static class ProductManager extends JobRole {
        public ProductManager() { super("Product Manager"); }
    }
    
    public static class Resume<T extends JobRole> {
        private String applicantName;
        private T role;
        public Resume(String name, T role) {
            this.applicantName = name;
            this.role = role;
        }
        public String getApplicantName() { return applicantName; }
        public T getRole() { return role; }
    }
    
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Processing " + resume.getApplicantName() + " for " + resume.getRole().getRoleName());
        }
    }
}
