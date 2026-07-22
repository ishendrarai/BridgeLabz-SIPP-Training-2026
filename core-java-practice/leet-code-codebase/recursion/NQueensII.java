public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        dfs(0, n, new int[n]);
        return count;
    }
    private void dfs(int r, int n, int[] cols) {
        if (r == n) { count++; return; }
        for (int c = 0; c < n; c++) {
            if (isValid(r, c, cols)) {
                cols[r] = c;
                dfs(r + 1, n, cols);
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
