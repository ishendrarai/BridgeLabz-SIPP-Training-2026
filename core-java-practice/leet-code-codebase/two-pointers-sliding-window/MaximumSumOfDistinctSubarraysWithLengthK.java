import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if (end - start + 1 > k) {
                sum -= nums[start];
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
            if (end - start + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
