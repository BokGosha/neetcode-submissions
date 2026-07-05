class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(board, visited, i, j, 0, word)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, int i, String word) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(i) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        boolean res = dfs(board, visited, row + 1, col, i + 1, word) ||
                dfs(board, visited, row - 1, col, i + 1, word) ||
                dfs(board, visited, row, col + 1, i + 1, word) ||
                dfs(board, visited, row, col - 1, i + 1, word);
        visited[row][col] = false;
        return res;
    }
}
