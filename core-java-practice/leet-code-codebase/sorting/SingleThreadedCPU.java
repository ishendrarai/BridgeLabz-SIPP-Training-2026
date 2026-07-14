import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] extTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            extTasks[i][0] = tasks[i][0];
            extTasks[i][1] = tasks[i][1];
            extTasks[i][2] = i;
        }
        Arrays.sort(extTasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1]));
        int[] res = new int[n];
        long time = 0;
        int i = 0, idx = 0;
        while (idx < n) {
            while (i < n && extTasks[i][0] <= time) {
                pq.offer(extTasks[i++]);
            }
            if (pq.isEmpty()) {
                time = extTasks[i][0];
                continue;
            }
            int[] task = pq.poll();
            res[idx++] = task[2];
            time += task[1];
        }
        return res;
    }
}
