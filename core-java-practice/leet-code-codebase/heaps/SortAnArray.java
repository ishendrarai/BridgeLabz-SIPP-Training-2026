public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(nums, n, i);
        for (int i = n - 1; i > 0; i--) {
            int t = nums[0]; nums[0] = nums[i]; nums[i] = t;
            heapify(nums, i, 0);
        }
        return nums;
    }
    private void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2*i+1, r = 2*i+2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int t = arr[i]; arr[i] = arr[largest]; arr[largest] = t;
            heapify(arr, n, largest);
        }
    }
}
