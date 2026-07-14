public class FirstLastOccurrence {
    public int[] searchRange(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) return new int[]{-1, -1};
        int last = findLast(arr, target);
        return new int[]{first, last};
    }
    
    private int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    
    private int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
