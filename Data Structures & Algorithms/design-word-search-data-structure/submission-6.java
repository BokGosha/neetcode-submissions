class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }

            cur = cur.children.get(c);
        }

        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    private boolean dfs(int j, TrieNode root, String word) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            Character c = word.charAt(i);

            if (c.equals('.')) {
                for (TrieNode child : cur.children.values()) {
                    if (dfs(i + 1, child, word)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }

                cur = cur.children.get(c);
            }
        }

        return cur.word;
    }
}
