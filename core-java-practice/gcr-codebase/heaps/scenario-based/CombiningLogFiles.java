import java.util.*;

class LogEntry {
    int timestamp;
    public LogEntry(int timestamp) { this.timestamp = timestamp; }
}

public class CombiningLogFiles {
    List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp - sources.get(b[0]).get(b[1]).timestamp
        );
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0], elemIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elemIdx));
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }
        return merged;
    }
}
