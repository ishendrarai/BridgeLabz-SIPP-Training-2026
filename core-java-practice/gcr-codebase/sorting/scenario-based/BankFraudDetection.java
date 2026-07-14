public class BankFraudDetection {
    public int suspiciousPairs(int[] amounts) {
        if (amounts == null || amounts.length <= 1) return 0;
        int[] temp = new int[amounts.length];
        return mergeSortAndCount(amounts, temp, 0, amounts.length - 1);
    }
    
    private int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += countPairs(arr, left, mid, right);
            merge(arr, temp, left, mid, right);
        }
        return count;
    }
    
    private int countPairs(int[] arr, int left, int mid, int right) {
        int count = 0, j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i] > 3L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
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
