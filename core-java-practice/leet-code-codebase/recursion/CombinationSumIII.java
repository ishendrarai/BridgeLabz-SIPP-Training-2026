import java.util.*;
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int k, int n, int start, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k && n == 0) { res.add(new ArrayList<>(curr)); return; }
        if (curr.size() == k || n < 0) return;
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            dfs(k, n - i, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
