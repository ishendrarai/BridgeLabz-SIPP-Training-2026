import java.util.Arrays;
import java.util.Random;

public class Day22_LibraryEfficientSorting {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random();
        
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) data[i] = rand.nextInt(10000);
            
            // Merge Sort
            int[] mergeData = data.clone();
            long start = System.nanoTime();
            mergeSort(mergeData, 0, size - 1);
            long end = System.nanoTime();
            long mergeTime = end - start;
            
            // Quick Sort
            int[] quickData = data.clone();
            start = System.nanoTime();
            quickSort(quickData, 0, size - 1);
            end = System.nanoTime();
            long quickTime = end - start;
            
            System.out.println("Size: " + size + " | Merge Sort: " + mergeTime + " ns | Quick Sort: " + quickTime + " ns");
        }
    }
    
    // Merge Sort
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    
    // Quick Sort
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[right]; arr[right] = temp;
        return i + 1;
    }
}
