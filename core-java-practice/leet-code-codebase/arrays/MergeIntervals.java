import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);
        for (int[] interval : intervals) {
            if (curr[1] >= interval[0]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                curr = interval;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
