import java.util.*;

public class Day29_DetectiveAgencyHashing {
    public static void main(String[] args) {
        Map<String, List<String>> suspects = new HashMap<>();
        suspects.put("Mr. X", Arrays.asList("Case1", "Case2", "Case3"));
        suspects.put("Ms. Y", Arrays.asList("Case1", "Case2"));
        suspects.put("Dr. Z", Arrays.asList("Case3"));
        
        // Most investigated
        String mostInvestigated = "";
        int maxCases = 0;
        for (Map.Entry<String, List<String>> entry : suspects.entrySet()) {
            if (entry.getValue().size() > maxCases) {
                maxCases = entry.getValue().size();
                mostInvestigated = entry.getKey();
            }
        }
        System.out.println("Most Investigated: " + mostInvestigated);
        
        // Exactly 2 cases
        System.out.print("Suspects in exactly 2 cases: ");
        for (Map.Entry<String, List<String>> entry : suspects.entrySet()) {
            if (entry.getValue().size() == 2) System.out.print(entry.getKey() + " ");
        }
        System.out.println();
        
        // Subarray sum equal to K
        int[] arr = {1, 2, 3, -1, 4, 2, -2};
        int target = 6;
        System.out.println("Subarrays with sum " + target + ": " + subarraySum(arr, target));
    }
    
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
