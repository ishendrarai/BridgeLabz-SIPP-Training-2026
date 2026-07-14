import java.util.PriorityQueue;
import java.util.Collections;

public class Day32_StockExchangeHeaps {
    public static void main(String[] args) {
        int[] caps = {500, 200, 800, 100, 900, 300};
        
        System.out.println("--- Build Max Heap from Scratch ---");
        buildMaxHeap(caps);
        System.out.println("Heapified array: " + java.util.Arrays.toString(caps));
        
        System.out.println("--- Top K Performing Stocks (PriorityQueue) ---");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : caps) pq.add(c);
        int k = 3;
        System.out.print("Top " + k + " stocks: ");
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
    
    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
