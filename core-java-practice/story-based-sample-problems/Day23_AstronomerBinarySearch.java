public class Day23_AstronomerBinarySearch {
    public static void main(String[] args) {
        int[] rotatedCatalog = {45, 56, 78, 89, 12, 23, 34};
        System.out.println("Min element: " + findMin(rotatedCatalog));
        
        int[] repeatedBright = {10, 20, 20, 20, 30, 40};
        System.out.println("First occurrence of 20: " + findFirst(repeatedBright, 20));
        System.out.println("Last occurrence of 20: " + findLast(repeatedBright, 20));
    }
    
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
    
    public static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    
    public static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
