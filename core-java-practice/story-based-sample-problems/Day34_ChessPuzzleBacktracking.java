import java.util.*;

public class Day34_ChessPuzzleBacktracking {
    public static void main(String[] args) {
        System.out.println("--- 4-Queens Problem ---");
        List<List<String>> queens = solveNQueens(4);
        System.out.println("Total solutions: " + queens.size());
        
        System.out.println("\n--- Combination Sum ---");
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println("Combinations for " + target + ": " + combinationSum(candidates, target));
    }
    
    // N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, board, res, n);
        return res;
    }
    
    private static void solve(int col, char[][] board, List<List<String>> res, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new String(board[i]));
            res.add(list);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, res, n);
                board[row][col] = '.';
            }
        }
    }
    
    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int i, j;
        for (i = 0; i < col; i++) if (board[row][i] == 'Q') return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (i = row, j = col; i < n && j >= 0; i++, j--) if (board[i][j] == 'Q') return false;
        return true;
    }
    
    // Combination Sum
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) { res.add(new ArrayList<>(tempList)); return; }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(res, tempList, candidates, remain - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
