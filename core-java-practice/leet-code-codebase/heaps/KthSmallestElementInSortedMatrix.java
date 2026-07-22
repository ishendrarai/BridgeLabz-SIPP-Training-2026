import java.util.*;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int j = 0; j <= Math.min(n - 1, k - 1); j++) {
            pq.offer(new int[]{matrix[0][j], 0, j});
        }
        int count = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            count++;
            if (count == k) return cell[0];
            int r = cell[1], c = cell[2];
            if (r + 1 < n) pq.offer(new int[]{matrix[r+1][c], r+1, c});
        }
        return -1;
    }
}
