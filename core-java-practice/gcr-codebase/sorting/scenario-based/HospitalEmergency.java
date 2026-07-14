import java.util.PriorityQueue;

public class HospitalEmergency {
    public int findKthHighestPriority(int[] priorities, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int p : priorities) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
