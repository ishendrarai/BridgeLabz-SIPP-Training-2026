import java.util.*;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) add(n);
    }
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
