import java.util.*;

class Patient {
    int severity;
    public Patient(int severity) { this.severity = severity; }
}

public class RealTimeEmergencyRoomTriage {
    PriorityQueue<Patient> triageQueue =
        new PriorityQueue<>((a, b) -> b.severity - a.severity);

    void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    Patient treatNext() {
        return triageQueue.poll();
    }
}
