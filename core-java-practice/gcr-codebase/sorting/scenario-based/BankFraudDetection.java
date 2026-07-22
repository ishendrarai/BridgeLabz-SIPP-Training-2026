public class BankFraudDetection {
    public int countSuspiciousPairs(int[] amount) {
        if (amount == null || amount.length < 2) return 0;
        return mergeSort(amount, new int[amount.length], 0, amount.length - 1);
    }
    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, temp, left, mid) + mergeSort(arr, temp, mid + 1, right);
        
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i] > 3L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        merge(arr, temp, left, mid, right);
        return count;
    }
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) temp[i] = arr[i];
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }
        while (i <= mid) arr[k++] = temp[i++];
    }
}
