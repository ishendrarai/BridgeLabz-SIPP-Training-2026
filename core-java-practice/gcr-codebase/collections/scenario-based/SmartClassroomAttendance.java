import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartClassroomAttendance {
    private Map<String, List<String>> attendance = new HashMap<>();
    
    public void markAttendance(String subject, String studentId) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        if (!attendance.get(subject).contains(studentId)) {
            attendance.get(subject).add(studentId);
        }
    }
    
    public void displayAttendance(String subject) {
        List<String> students = attendance.getOrDefault(subject, new ArrayList<>());
        System.out.println("Subject: " + subject + " - Total Present: " + students.size());
        for (String student : students) {
            System.out.println(student);
        }
    }
}
