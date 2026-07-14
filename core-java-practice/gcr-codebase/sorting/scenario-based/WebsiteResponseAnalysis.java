public class WebsiteResponseAnalysis {
    public int countViolations(int[] responses) {
        if (responses == null || responses.length <= 1) return 0;
        int[] temp = new int[responses.length];
        return mergeSortAndCount(responses, temp, 0, responses.length - 1);
    }

    private int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    private int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) temp[i] = arr[i];
        int i = left, j = mid + 1, k = left;
        int swaps = 0;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                swaps += (mid + 1 - i);
            }
        }
        while (i <= mid) arr[k++] = temp[i++];
        return swaps;
    }
}
