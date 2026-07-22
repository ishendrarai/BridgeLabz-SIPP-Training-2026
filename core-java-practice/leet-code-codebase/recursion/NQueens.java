import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, n, new int[n], res);
        return res;
    }
    private void dfs(int r, int n, int[] cols, List<List<String>> res) {
        if (r == n) {
            List<String> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[cols[i]] = 'Q';
                b.add(new String(row));
            }
            res.add(b);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (isValid(r, c, cols)) {
                cols[r] = c;
                dfs(r + 1, n, cols, res);
            }
        }
    }
    private boolean isValid(int r, int c, int[] cols) {
        for (int i = 0; i < r; i++) {
            if (cols[i] == c || Math.abs(i - r) == Math.abs(cols[i] - c)) return false;
        }
        return true;
    }
}
