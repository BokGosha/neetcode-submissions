class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }

            cur = cur.children.get(c);
        }

        cur.endOfWord = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            root.addWord(w);
        }

        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];
        Set<String> res = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(res, board, visited, i, j, root, "");
            }
        }

        return new ArrayList(res);
    }

    private void dfs(Set<String> res, char[][] board, boolean[][] visited, int row, int col, TrieNode node, String word) {
        if (row < 0 || col < 0 ||
        row >= board.length || col >= board[0].length ||
        visited[row][col] ||
        !node.children.containsKey(board[row][col])) {
            return;
        }

        visited[row][col] = true;
        node = node.children.get(board[row][col]);
        word += board[row][col];
        if (node.endOfWord) {
            res.add(word);
        }

        dfs(res, board, visited, row + 1, col, node, word);
        dfs(res, board, visited, row - 1, col, node, word);
        dfs(res, board, visited, row, col + 1, node, word);
        dfs(res, board, visited, row, col - 1, node, word);

        visited[row][col] = false;
    }
}
