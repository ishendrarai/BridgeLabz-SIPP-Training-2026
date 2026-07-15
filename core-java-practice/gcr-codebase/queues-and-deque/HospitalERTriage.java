import java.util.PriorityQueue;

public class HospitalERTriage {
    class Patient {
        int priority;
        String name;
        Patient(int priority, String name) { 
            this.priority = priority; 
            this.name = name; 
        }
    }

    PriorityQueue<Patient> triageQueue = 
        new PriorityQueue<>((a, b) -> a.priority - b.priority); // min-heap by priority

    void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    Patient callNextPatient() {
        return triageQueue.poll(); // always the most urgent (lowest priority number)
    }
}
