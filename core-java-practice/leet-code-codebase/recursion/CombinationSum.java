import java.util.*;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] c, int t, int i, List<Integer> curr, List<List<Integer>> res) {
        if (t == 0) { res.add(new ArrayList<>(curr)); return; }
        if (t < 0 || i == c.length) return;
        curr.add(c[i]);
        dfs(c, t - c[i], i, curr, res);
        curr.remove(curr.size() - 1);
        dfs(c, t, i + 1, curr, res);
    }
}
