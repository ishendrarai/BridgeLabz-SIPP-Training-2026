public class HospitalEmergency {
    public int getKthHighestPriority(int[] priorities, int k) {
        return quickSelect(priorities, 0, priorities.length - 1, priorities.length - k);
    }
    private int quickSelect(int[] arr, int low, int high, int k) {
        int pivot = partition(arr, low, high);
        if (pivot == k) return arr[pivot];
        else if (pivot < k) return quickSelect(arr, pivot + 1, high, k);
        else return quickSelect(arr, low, pivot - 1, k);
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}
