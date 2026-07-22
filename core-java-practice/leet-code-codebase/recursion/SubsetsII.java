import java.util.*;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            dfs(nums, j + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
