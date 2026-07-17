import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiff {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[j]) maxQ.pollLast();
            while (!minQ.isEmpty() && minQ.peekLast() > nums[j]) minQ.pollLast();
            maxQ.add(nums[j]);
            minQ.add(nums[j]);
            if (maxQ.peek() - minQ.peek() > limit) {
                if (maxQ.peek() == nums[i]) maxQ.poll();
                if (minQ.peek() == nums[i]) minQ.poll();
                i++;
            }
        }
        return j - i;
    }
}
