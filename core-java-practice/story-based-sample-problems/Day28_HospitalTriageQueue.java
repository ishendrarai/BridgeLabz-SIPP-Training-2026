import java.util.PriorityQueue;
import java.util.Deque;
import java.util.LinkedList;

public class Day28_HospitalTriageQueue {
    static class Patient implements Comparable<Patient> {
        String name;
        int severity; // higher is more urgent
        public Patient(String n, int s) { name = n; severity = s; }
        @Override
        public int compareTo(Patient p) { return Integer.compare(p.severity, this.severity); }
        @Override
        public String toString() { return name + " (Severity: " + severity + ")"; }
    }
    
    public static void main(String[] args) {
        // Triage
        PriorityQueue<Patient> triage = new PriorityQueue<>();
        triage.add(new Patient("Alice", 2));
        triage.add(new Patient("Bob", 5)); // Most severe
        triage.add(new Patient("Charlie", 1));
        
        System.out.println("Processing patients:");
        while (!triage.isEmpty()) {
            System.out.println("Treating: " + triage.poll());
        }
        
        // Sliding window maximum (Vitals)
        int[] vitals = {98, 99, 102, 105, 103, 100, 99};
        int k = 3;
        System.out.println("\nSliding Window Max Vitals: " + java.util.Arrays.toString(maxSlidingWindow(vitals, k)));
    }
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) res[ri++] = nums[q.peek()];
        }
        return res;
    }
}
