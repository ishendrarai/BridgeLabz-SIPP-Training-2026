import java.util.*;

public class Day24_RiverStationTwoPointers {
    public static void main(String[] args) {
        int[] levels = {2, 4, 3, 6, 8, 3, 2, 4};
        int minRange = 2, maxRange = 5;
        // Find longest contiguous period where levels stayed within [minRange, maxRange]
        int longest = 0, start = 0;
        for (int end = 0; end < levels.length; end++) {
            if (levels[end] < minRange || levels[end] > maxRange) {
                start = end + 1;
            } else {
                longest = Math.max(longest, end - start + 1);
            }
        }
        System.out.println("Longest period in range: " + longest);
        
        // 3Sum to zero
        int[] stations = {-1, 0, 1, 2, -1, -4};
        System.out.println("Zero pollution triplets: " + threeSum(stations));
        
        // Max average subarray
        int[] kData = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Max average of length " + k + ": " + maxAverage(kData, k));
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++; r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
    
    public static double maxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}
