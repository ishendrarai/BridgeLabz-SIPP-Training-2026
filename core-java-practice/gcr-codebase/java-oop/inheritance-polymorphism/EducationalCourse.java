public class EducationalCourse {
    static class Course {
        String courseName;
        int duration;

        public Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        public double calculateFinalFee() {
            return fee - (fee * discount / 100);
        }

        public void printCourseDetails() {
            System.out.println("Course: " + courseName + " | Duration: " + duration + " hrs");
            System.out.println("Platform: " + platform + " | Recorded: " + isRecorded);
            System.out.println("Original Fee: $" + fee + " | Final Fee: $" + calculateFinalFee());
        }
    }

    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Mastery", 40, "Udemy", true, 100.0, 20.0);
        course.printCourseDetails();
    }
}
