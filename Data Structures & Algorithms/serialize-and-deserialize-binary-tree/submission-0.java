/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    StringBuilder b = new StringBuilder();
    int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return b.toString();
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            b.append("N,");
            return;
        }

        b.append(node.val).append(",");

        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return dfs(vals);
    }

    private TreeNode dfs(String[] vals) {
        if (Objects.equals(vals[i], "N")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
        i++;
        node.left = dfs(vals);
        node.right = dfs(vals);

        return node;
    }
}
