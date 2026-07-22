import java.util.*;
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] c, int t, int start, List<Integer> curr, List<List<Integer>> res) {
        if (t == 0) { res.add(new ArrayList<>(curr)); return; }
        if (t < 0) return;
        for (int i = start; i < c.length; i++) {
            if (i > start && c[i] == c[i-1]) continue;
            if (t - c[i] < 0) break;
            curr.add(c[i]);
            dfs(c, t - c[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
