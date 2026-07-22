public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, i, j, word, 0)) return true;
        return false;
    }
    private boolean dfs(char[][] b, int i, int j, String w, int idx) {
        if (idx == w.length()) return true;
        if (i < 0 || j < 0 || i == b.length || j == b[0].length || b[i][j] != w.charAt(idx)) return false;
        char temp = b[i][j];
        b[i][j] = '*';
        boolean res = dfs(b, i+1, j, w, idx+1) || dfs(b, i-1, j, w, idx+1) || dfs(b, i, j+1, w, idx+1) || dfs(b, i, j-1, w, idx+1);
        b[i][j] = temp;
        return res;
    }
}
