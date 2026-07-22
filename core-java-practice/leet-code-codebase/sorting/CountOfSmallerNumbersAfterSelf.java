import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) indexes[i] = i;
        mergeSort(nums, indexes, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) res.add(count[i]);
        return res;
    }
    private void mergeSort(int[] nums, int[] indexes, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, indexes, left, mid);
        mergeSort(nums, indexes, mid + 1, right);
        merge(nums, indexes, left, mid, right);
    }
    private void merge(int[] nums, int[] indexes, int left, int mid, int right) {
        int[] newIndexes = new int[right - left + 1];
        int rightCount = 0, i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                newIndexes[k++] = indexes[j++];
                rightCount++;
            } else {
                count[indexes[i]] += rightCount;
                newIndexes[k++] = indexes[i++];
            }
        }
        while (i <= mid) {
            count[indexes[i]] += rightCount;
            newIndexes[k++] = indexes[i++];
        }
        while (j <= right) newIndexes[k++] = indexes[j++];
        for (int idx = left; idx <= right; idx++) {
            indexes[idx] = newIndexes[idx - left];
        }
    }
}
